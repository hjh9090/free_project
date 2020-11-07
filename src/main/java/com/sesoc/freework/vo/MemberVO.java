package com.sesoc.freework.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	//네이버 정보를 받아오기 위한 VO
	private String id;
	private String name;
	private String email;
	private String gender;
	private String birth;
	
}
