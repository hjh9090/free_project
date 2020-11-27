package com.sesoc.freework.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.sesoc.freework.dao.MemberDAO;

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
	
	
	
	
}
