package com.spring.db.movie.dao;

import com.spring.db.movie.dto.MovieMemberDTO;

public interface MovieDAO {
	
	public static final int MOVIE_PRICE = 10000;
	
	// 로그인
	public int loginCheck(String userId, String userPw);
	
	// 회원의 정보를 얻는 메소드
	public MovieMemberDTO getMemeber(String userId);
	
	// 영화 티켓 구입 메소드
	public void buyTicket(String userId, int ticketNumber);
	
	// 티켓 수를 얻는 메소드
	public int getTicketNumber(String userId);
	
}
