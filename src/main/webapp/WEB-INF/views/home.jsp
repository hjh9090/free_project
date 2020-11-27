<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>상담 커뮤니티</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style type="text/css">
#mainButton {
font-size: 20pt;
text-align: center;
padding: 0px;
}

#mainTable{
font-size: 20pt;
text-align: center;
padding: 0px;
}

</style>

</head>
<body>

<%
    String clientId = "twfSAY19vmy4Kxca7JHF";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8888/freework/callback", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
 %>


<h1>
	상담 커뮤니티에 오신 것을 환영합니다
</h1>
<div id = "mainButton">
<table id = "mainTable">
	
	<tr>
		<p>네이버로 로그인 하기</p>
		<a href="<%=apiURL%>"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
		
		<td>상담 게시판으로 이동</td>
	</tr>
</table>
</div>


</body>
</html>
