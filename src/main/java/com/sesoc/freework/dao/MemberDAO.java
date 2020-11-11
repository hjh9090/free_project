package com.sesoc.freework.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.freework.vo.MemberVO;

@Repository
public class MemberDAO {

	
	@Autowired
	private SqlSession session;
	
	//네이버 API 객체를 집어 넣음
	public int insertMember (MemberVO member) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int result = 0;
		try {
			result = mapper.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int getMember (String id) {
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int result = 0;
		try {
			result = mapper.getMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
	
	
}
