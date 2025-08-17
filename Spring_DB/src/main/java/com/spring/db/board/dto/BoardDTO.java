package com.spring.db.board.dto;

import java.sql.Timestamp;

public class BoardDTO {
	
	private Integer id;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate;
	private Integer viewCount;
	
	public BoardDTO() {
		
	}

	public BoardDTO(Integer id, String writer, String title, String content, Timestamp regDate, Integer viewCount) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.viewCount = viewCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
	
}
