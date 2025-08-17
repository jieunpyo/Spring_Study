package com.spring.db.movie.dto;

public class MovieMemberDTO {
	
//	USER_ID VARCHAR2(20) PRIMARY KEY,
//	USER_PW VARCHAR2(20) NOT NULL,
//	USER_NAME NVARCHAR2(20) NOT NULL,
//	POINT NUMBER DEFAULT 100000
	
	private String userId;
	private String userPw;
	private String userName;
	private Integer point;
	
	// 기본생성자
	public MovieMemberDTO() {
		
	}
	
	// 초기화생성자
	public MovieMemberDTO(String userId, String userPw, String userName, Integer point) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.point = point;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}
	
	
	
	
}
