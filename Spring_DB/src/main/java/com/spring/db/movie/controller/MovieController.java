package com.spring.db.movie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.db.movie.dao.MovieDAO;
import com.spring.db.movie.dto.MovieMemberDTO;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieDAO dao;
	
	@GetMapping("/login")
	public String loginForm() {
		return "movie/loginForm";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userId")String userId, 
						@RequestParam("userPw")String userPw, HttpSession session) {
		
		int result = dao.loginCheck(userId, userPw);
		
		if(result == 1) {
			
			MovieMemberDTO dto = dao.getMemeber(userId);
			session.setAttribute("movie", dto);
			return "redirect:/movie/main";
			
		}else {
			return "redirect:/movie/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/movie/login";
	}
	
	
	@GetMapping("/buyTicket")
	public String buyTicket() {
		
		return "movie/buyTicket";
	}
	
	@PostMapping("/buyTicket")
	public String buyTicket(@RequestParam("userId")String userId, 
							@RequestParam("ticketNumber")Integer ticketNumber) {
		
		dao.buyTicket(userId, ticketNumber);
		
		return "redirect:/movie/main"; 
	}
	
	@GetMapping("/main")
	public String movieMain(HttpSession session) {
		
		if(session.getAttribute("movie") != null) {
			
			MovieMemberDTO dto = (MovieMemberDTO)session.getAttribute("movie");
			String userId = dto.getUserId();
			
			MovieMemberDTO dto2 = dao.getMemeber(userId);
			session.setAttribute("movie", dto2);
			
			int ticketNumber = dao.getTicketNumber(userId);
			session.setAttribute("ticketNumber", ticketNumber);
			
			return "movie/main";
			
		}else {
			return "redirect:/movie/login";
		}
		
		
	}
	
	
	
	
}






