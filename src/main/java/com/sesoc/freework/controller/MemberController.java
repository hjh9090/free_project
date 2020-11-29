package com.sesoc.freework.controller;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.sesoc.freework.dao.MemberDAO;
import com.sesoc.freework.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private RestTemplate resttemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@GetMapping("callback")
	public String naverLogin (HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
		logger.info("콜백으로 들어옴");
		
		return "member/callback";
	}
	
	@GetMapping("sendtoken")
	@ResponseBody
	public String sendToken (String access_token, HttpSession httpsession, MemberVO vo)throws Exception {
		
		logger.info("토큰 값 컨트롤러로 들어왔음");
		
		String header = "Bearer " + access_token;//해더 받아옵니다.
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json; charset=UTF-8");
		headers.set("Authorization", header);//해더 받아오는 형식과 인코딩 형식 설정
		HttpEntity entity = new HttpEntity(headers);
		
		Map<String, Object> result = resttemplate.exchange("https://openapi.naver.com/v1/nid/me", HttpMethod.GET, entity, Map.class).getBody();
		Map<String, String> naverInfo = (LinkedHashMap<String, String>) result.get("response");
		//추후 코드 분석 할 예정
		String id = naverInfo.get("id");
		String name =  naverInfo.get("name");
		String email = naverInfo.get("email");
		String gender = naverInfo.get("gender");
		String birth = naverInfo.get("birthday");
		
		logger.debug(id);
		logger.debug(name);
		logger.debug(email);
		logger.debug(gender);
		logger.debug(birth);
		
		vo.setId(id);
		vo.setName(name);
		vo.setEmail(email);
		vo.setGender(gender);
		vo.setBirth(birth);
		
		int result2 = dao.getMember(id);
		
		
		if(result2 == 0 ) {
			dao.insertMember(vo);
		}// DB에 존재하는 아이디가 없을 경우에 받아온 정보를 집어 넣는다.
		
		httpsession.setAttribute("session_id", id);
		httpsession.setAttribute("session_name", name);
		httpsession.setAttribute("session_email", email);
		httpsession.setAttribute("session_gender", gender);
		httpsession.setAttribute("session_birth", birth);
		logger.debug((String)httpsession.getAttribute("access_token"));
		
		return "";
		
	}//end insert
	
	
}
