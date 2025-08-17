package com.spring.mvc.member.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	List<MemberVO> list = new ArrayList<>();
	
	@Override
	public List<MemberVO> memberList() {
		return list;
	}

	@Override
	public boolean memberInsert(MemberVO member) {
		// 회원가입이 되었으면 true반환, 아니라면 false반환
		
		if(list.add(member)) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean memberIdCheck(String id) {
		// 같은 아이디가 있다면 true 반환, 같은 아이디가 없다면 false반환
		
		for(int i = 0; i < list.size(); i++) {
			
			MemberVO member = list.get(i);
			
			if(member.getId().equals(id)) {
				return true;
			}
			
		}
		
		return false;
	}

	@Override
	public MemberVO getMemeber(String id) {
		// id 에 해당하는 MemberVO 객체 반환
		
		for(int i = 0; i < list.size(); i++) {
			
			MemberVO member = list.get(i);
			
			if(member.getId().equals(id)) {
				
				return member;
			}
		}
		
		return null;
	}

	@Override
	public boolean memberEdit(MemberVO member) {
		// id에 해당하는 멤버객체의 pw, tel, email, address 수정
		
		for(int i = 0; i < list.size(); i++) {
			
			MemberVO member2 = list.get(i);
			
			if(member2.getId().equals(member.getId())) {
				
				member2.setPw(member.getPw());
				member2.setTel(member.getTel());
				member2.setEmail(member.getEmail());
				member2.setAddress(member.getAddress());
				
				return true;
				
			}
		}
		return false;
	}

	@Override
	public boolean memberDelete(String id) {
		// id에 해당하는 멤버객체 삭제
		
		for(int i = 0; i < list.size(); i++) {
			
			MemberVO member = list.get(i);
			
			if(member.getId().equals(id)){
				
				list.remove(i);
				return true;
			}
			
		}
		
		return false;
	}

}
