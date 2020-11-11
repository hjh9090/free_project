package com.sesoc.freework.dao;


import com.sesoc.freework.vo.MemberVO;

public interface MemberMapper {

	
	public int insertMember (MemberVO member);
	
	public int getMember (String id);
	
}
