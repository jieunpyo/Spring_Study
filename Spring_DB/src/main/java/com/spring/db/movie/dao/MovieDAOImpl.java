package com.spring.db.movie.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.spring.db.movie.dto.MovieMemberDTO;

@Repository
public class MovieDAOImpl implements MovieDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
//	@Autowired
//	private PlatformTransactionManager tranManager;
	
	@Autowired
	private TransactionTemplate template;
	
	
	@Override
	public int loginCheck(String userId, String userPw) {
//		USER_ID VARCHAR2(20) PRIMARY KEY,
//		USER_PW VARCHAR2(20) NOT NULL,
//		USER_NAME NVARCHAR2(20) NOT NULL,
//		POINT NUMBER DEFAULT 100000
		
		String query = "SELECT USER_PW FROM MOVIE_MEMBER WHERE USER_ID = ?";
		
		String dbPw = jt.queryForObject(query, new RowMapper<String>() {
			
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				String userPw = rs.getString("USER_PW");
				
				return userPw;
			}
			
		}, userId);
		
		if(dbPw == null) { //아이디가 없는경우 
			return -1;
		}else { // 아이디가 있는경우
			
			if(dbPw.equals(userPw)) { // 비밀번호가 맞는경우
				
				return 1;
				
			}else { // 비밀번호가 틀린경우
				
				return 0;
				
			}
			
		}
		
	}
	
	@Override
	public MovieMemberDTO getMemeber(String userId) {
		
		MovieMemberDTO dto = null;
		
		String query = "SELECT * FROM MOVIE_MEMBER WHERE USER_ID = ?";
		
		dto = jt.queryForObject(query, new RowMapper<MovieMemberDTO>() {
			
			@Override
			public MovieMemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				String userId = rs.getString("USER_ID");
				String userPw = rs.getString("USER_PW");
				String userName = rs.getString("USER_NAME");
				Integer point = rs.getInt("POINT");
				
				MovieMemberDTO dto = new MovieMemberDTO(userId, userPw, userName, point);
				
				return dto;
			}
			
		}, userId);
		
		return dto;
	}

	@Override
	public void buyTicket(String userId, int ticketNumber) {
		
		// TransactionDefinition : 트랜잭션이 구동하는데 필요한 기본적인 객체
//		TransactionDefinition definition = new DefaultTransactionDefinition();
//		
//		TransactionStatus status = tranManager.getTransaction(definition);
		// TransactionStatus : 트랜잭션 실행 및 상태를 제어할 수 있는 객체
		
//		try {
//		
//			String query1 = "UPDATE MOVIE_MEMBER SET POINT = POINT - ? "
//								+ "WHERE USER_ID = ?";
//			
//			jt.update(query1, MovieDAO.MOVIE_PRICE * ticketNumber, userId);
//			
//			String query2 = "UPDATE MOVIE_TICKET SET TICKET_NUMBER = TICKET_NUMBER + ? "
//								+ "WHERE USER_ID = ?";
//			
//			jt.update(query2, ticketNumber, userId);
//			
//			tranManager.commit(status);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//			tranManager.rollback(status);
//			
//		}
		
		template.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				String query1 = "UPDATE MOVIE_MEMBER SET POINT = POINT - ? "
						+ "WHERE USER_ID = ?";

				jt.update(query1, MovieDAO.MOVIE_PRICE * ticketNumber, userId);
				
				String query2 = "UPDATE MOVIE_TICKET SET TICKET_NUMBER = TICKET_NUMBER + ? "
								+ "WHERE USER_ID = ?";
				
				jt.update(query2, ticketNumber, userId);
				
			}
			
		});
		
		
		
		
		
	}

	@Override
	public int getTicketNumber(String userId) {
		
		String query = "SELECT TICKET_NUMBER FROM MOVIE_TICKET WHERE USER_ID = ?";
		
		int ticketNumber = jt.queryForObject(query, new RowMapper<Integer>() {
			
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				int ticketNumber = rs.getInt("TICKET_NUMBER");
				
				return ticketNumber;
			}
			
		}, userId);
		
		return ticketNumber;
	}

}





