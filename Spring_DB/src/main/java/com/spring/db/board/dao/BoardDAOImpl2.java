package com.spring.db.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.board.dto.BoardDTO;

@Repository("dao2")
public class BoardDAOImpl2 implements BoardDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<BoardDTO> boardList() {
		
		String query = "SELECT * FROM BOARD ORDER BY ID DESC";
		
		List<BoardDTO> list = jt.query(query, new BoardMapper());
		
		return list;
	}

	@Override
	public int write(BoardDTO dto) {
		
		String query = "INSERT INTO BOARD(ID, WRITER, TITLE, CONTENT) "
				+ "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";
		
		int result = jt.update(query, dto.getWriter(), dto.getTitle(), dto.getContent());
		
		return result;
	}

	@Override
	public BoardDTO getContent(int id) {
		
		String query = "SELECT * FROM BOARD WHERE ID = ?";
		
		BoardDTO dto = jt.queryForObject(query, new BoardMapper(), id);
		
		return dto;
	}

	@Override
	public void upViewCount(int id) {
		
		String query = "UPDATE BOARD SET VIEW_COUNT = VIEW_COUNT + 1 WHERE ID = ?";
		
		jt.update(query, id);

	}

	@Override
	public int boardUpdate(BoardDTO dto) {
		
		String query = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE ID = ?";
		
		int result = jt.update(query, dto.getTitle(), dto.getContent(), dto.getId());
		
		return result;
	}

	@Override
	public int boardDelete(int id) {
		
		String query = "DELETE FROM BOARD WHERE ID = ?";
		
		int result = jt.update(query, id);
		
		return result;
	}

}
