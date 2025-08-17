package com.spring.mvc.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.member.repository.MemberVO;
import com.spring.mvc.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 회원가입시 회원가입폼 페이지 요청
	@GetMapping("/join")
	public String joinForm() {
		return "member/joinForm";
	}
	
	// 회원가입 요청
	@PostMapping("/join")
	public String memberJoin(MemberVO member, RedirectAttributes ra) {
		
		// addFlashAttribute : 리다이렉트 직전 플래시에 데이터를 저장하는 메소드
		// 일회성 데이터를 보내주기 때문에 리다이렉트 이후에는 소멸한다.
		
		boolean idCheck = service.memberIdCheck(member.getId());
		
		if(idCheck == true) {
			ra.addFlashAttribute("msg", "같은 아이디가 있습니다.");
			return "redirect:/member/join";
		}
		
		boolean insertCheck = service.memberInsert(member);
		
		if(insertCheck == true) {
			
			ra.addFlashAttribute("msg", "회원가입 되었습니다.");
			return "redirect:/member/list";
			
		}else {
			ra.addFlashAttribute("msg", "회원가입 실패입니다.");
			return "redirect:/member/join";
		}
		
		
	}
	
	// 회원의 목록 페이지 요청
	@GetMapping("/list")
	public String memberList(Model model) {
		
		List<MemberVO> list = service.memberList();
		
		model.addAttribute("memberList", list);
		
		return "member/memberList";
	}
	
	// 한명의 회원정보 페이지 요청
	@GetMapping("/info")
	public String memberInfo(@RequestParam("id")String id, Model model) {
		
		MemberVO member = service.getMemeber(id);
		
		model.addAttribute("member", member);
		
		return "member/memberInfo";
	}
	
	// 회원정보 수정 폼 페이지 요청
	@PostMapping("/modifyForm")
	public String memberModify(@RequestParam("id")String id, Model model) {
		
		MemberVO member = service.getMemeber(id);
		
		model.addAttribute("member", member);
		
		return "member/modifyForm";
	}
	
	// 회원정보 수정 요청
	@PostMapping("/modify")
	public String memberModify(MemberVO member, RedirectAttributes ra) {
		
		boolean bool = service.memberEdit(member);
		
		if(bool) {
			ra.addFlashAttribute("msg", "회원정보 수정되었습니다.");
			return "redirect:/member/info?id=" + member.getId();
		}else {
			
			ra.addFlashAttribute("msg", "회원정보 수정 실패입니다.");
			return "redirect:/member/info?id=" + member.getId();
			
		}
		
	}
	
	
	// 회원 삭제 요청
	@PostMapping("/delete")
	public String memberDelete(@RequestParam("id")String id, RedirectAttributes ra) {
		
		boolean bool = service.memberDelete(id);
		
		if(bool) {
			ra.addFlashAttribute("msg", "회원탈퇴 되었습니다.");
		}else {
			ra.addFlashAttribute("msg", "회원탈퇴 실패입니다.");
		}
		
		return "redirect:/member/list";
	}
	
	
	
	
}
