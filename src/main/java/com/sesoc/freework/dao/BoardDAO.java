package com.sesoc.freework.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.freework.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession session;
	
	public int insertBoard (BoardVO board) {
		int result = 0;
		
		
		return result;
	}
	
	
}
