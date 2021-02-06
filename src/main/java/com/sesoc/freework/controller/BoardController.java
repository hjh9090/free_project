package com.sesoc.freework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sesoc.freework.dao.BoardDAO;


@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	
	
}
