package com.spring.mvc.member.repository;

import java.util.List;

public interface MemberDAO {
	
	// 회원 전체 목록을 조회하기 위해 데이터를 얻는 메소드
	public List<MemberVO> memberList();
	
	// 회원가입 후 회원의 데이터를 넣는 메소드
	public boolean memberInsert(MemberVO member);
	
	// 회원 가입전에 같은 아이디가 있는지 체크해주는 메소드
	public boolean memberIdCheck(String id);
	
	// 해당 회원의 정보를 반환해주는 메소드
	public MemberVO getMemeber(String id);
	
	// 해당 회원의 정보를 수정해주는 메소드
	public boolean memberEdit(MemberVO member);
	
	// 해당 회원을 삭제해주는 메소드
	public boolean memberDelete(String id);
	
}
