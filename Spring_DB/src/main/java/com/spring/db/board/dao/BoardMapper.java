package com.spring.db.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.spring.db.board.dto.BoardDTO;

public class BoardMapper implements RowMapper<BoardDTO>{
	
	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Integer id = rs.getInt("ID");
		String writer = rs.getString("WRITER");
		String title = rs.getString("TITLE");
		String content = rs.getString("CONTENT");
		Timestamp regDate = rs.getTimestamp("REG_DATE");
		Integer viewCount = rs.getInt("VIEW_COUNT");
		
		BoardDTO dto = new BoardDTO(id, writer, title, content, regDate, viewCount);
		
		return dto;
	}
	
}



