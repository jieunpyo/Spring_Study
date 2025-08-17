package com.spring.db.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.db.board.dto.BoardDTO;
import com.zaxxer.hikari.HikariDataSource;

@Repository("dao1")
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private HikariDataSource ds;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public List<BoardDTO> boardList() {
		
		List<BoardDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM BOARD ORDER BY ID DESC";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
//			ID	NUMBER(4,0)
//			WRITER	NVARCHAR2(20 CHAR)
//			TITLE	NVARCHAR2(100 CHAR)
//			CONTENT	NVARCHAR2(500 CHAR)
//			REG_DATE	TIMESTAMP(6)
//			VIEW_COUNT	NUMBER(4,0)
			
			while(rs.next()) {
				
				Integer id = rs.getInt("ID");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Timestamp regDate = rs.getTimestamp("REG_DATE");
				Integer viewCount = rs.getInt("VIEW_COUNT");
				
				list.add(new BoardDTO(id, writer, title, content, regDate, viewCount));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				
			}catch(Exception e2) {}
			
		}
		
		return list;
	}

	@Override
	public int write(BoardDTO dto) {
//		ID	NUMBER(4,0)
//		WRITER	NVARCHAR2(20 CHAR)
//		TITLE	NVARCHAR2(100 CHAR)
//		CONTENT	NVARCHAR2(500 CHAR)
//		REG_DATE	TIMESTAMP(6)
//		VIEW_COUNT	NUMBER(4,0)
		int result = 0;
		
		String query = "INSERT INTO BOARD(ID, WRITER, TITLE, CONTENT) "
				+ "VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				
			}catch(Exception e2) {}
			
		}
		
		return result;
	}

	@Override
	public BoardDTO getContent(int id) {
		
		BoardDTO dto = null;
		
		String query = "SELECT * FROM BOARD WHERE ID = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				id = rs.getInt("ID");
				String writer = rs.getString("WRITER");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Timestamp regDate = rs.getTimestamp("REG_DATE");
				Integer viewCount = rs.getInt("VIEW_COUNT");
				
				dto = new BoardDTO(id, writer, title, content, regDate, viewCount);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				
			}catch(Exception e2) {}
			
		}
		
		return dto;
	}

	@Override
	public void upViewCount(int id) {
		
		String query = "UPDATE BOARD SET VIEW_COUNT = VIEW_COUNT + 1 WHERE ID = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				
			}catch(Exception e2) {}
			
		}
		
		
	}

	@Override
	public int boardUpdate(BoardDTO dto) {
		
		int result = 0;
		
		String query = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE ID = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				
			}catch(Exception e2) {}
			
		}
		
		
		return result;
	}

	@Override
	public int boardDelete(int id) {
		
		int result = 0;
		
		String query = "DELETE FROM BOARD WHERE ID = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
				
			}catch(Exception e2) {}
			
		}
		
		return result;
	}

}





