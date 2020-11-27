<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>잠시만 기다려 주십시오.</title>
<script>
window.onload = function() 
{
	setTimeout(function(){ SendToken(); }, 2000);
}
function SendToken () {
	var token = $('tetToken').value;
	console.log(token);
	/* $.ajax ({
		url : 
		
		}) */
}
</script>
</head>
<body>
	<%
String strTokenFull = "";
    String clientId = "twfSAY19vmy4Kxca7JHF";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "YeKOa7u7la";//애플리케이션 클라이언트 시크릿값";
    String code = request.getParameter("code");
    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http://localhost:8888/freework/callback", "UTF-8");
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + clientId;
    apiURL += "&client_secret=" + clientSecret;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    String access_token = "";
    String refresh_token = "";
    System.out.println("apiURL="+apiURL);
    try {
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection)url.openConnection();
      con.setRequestMethod("GET");
      int responseCode = con.getResponseCode();
      BufferedReader br;
      System.out.print("responseCode="+responseCode);
      if(responseCode==200) { // 정상 호출
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      } else {  // 에러 발생
        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      }
      String inputLine;
      StringBuffer res = new StringBuffer();
      while ((inputLine = br.readLine()) != null) {
        res.append(inputLine);
      }
      br.close();
      if(responseCode==200) {
    	  strTokenFull = res.toString();
//         out.println(res.toString());
//         out.println(strTokenFull);
        
        int itmp = strTokenFull.indexOf("refresh_token");
        access_token = strTokenFull.substring(17, itmp - 3);
//         out.println("\n\n");
//         out.println(access_token);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  %>
	
<input type="hidden" id="txtToken" value="<%=access_token%>">
	
	

</body>
</html>