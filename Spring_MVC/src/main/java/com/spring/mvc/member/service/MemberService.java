package com.spring.mvc.member.service;

import java.util.List;

import com.spring.mvc.member.repository.MemberVO;

public interface MemberService {
	
	public List<MemberVO> memberList();
	
	public boolean memberInsert(MemberVO member);
	
	public boolean memberIdCheck(String id);
	
	public MemberVO getMemeber(String id);
	
	public boolean memberEdit(MemberVO member);
	
	public boolean memberDelete(String id);
	
}
