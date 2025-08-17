package com.spring.mvc.member.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.member.repository.MemberDAO;
import com.spring.mvc.member.repository.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public boolean memberInsert(MemberVO member) {
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		
		member.setRegDate(time);
		
		return dao.memberInsert(member);
		
	}

	@Override
	public boolean memberIdCheck(String id) {
		return dao.memberIdCheck(id);
	}

	@Override
	public MemberVO getMemeber(String id) {
		return dao.getMemeber(id);
	}

	@Override
	public boolean memberEdit(MemberVO member) {
		return dao.memberEdit(member);
	}

	@Override
	public boolean memberDelete(String id) {
		return dao.memberDelete(id);
	}

}
