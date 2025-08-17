package com.spring.db.board.dao;

import java.util.List;

import com.spring.db.board.dto.BoardDTO;

public interface BoardDAO {
	
	// 1. 게시판 목록페이지를 만들기 위해 데이터를 얻는 메소드
	public List<BoardDTO> boardList();
	
	// 2. 글 작성 후 데이터를 넣는 메소드
	public int write(BoardDTO dto);
	
	// 3. 제목 클릭시 해당 글페이지를 만들기 위해 데이터를 얻는 메소드
	public BoardDTO getContent(int id);
	
	// 4. 조회수를 1나 증가시켜주는 기능의 메소드
	public void upViewCount(int id);
	
	// 5. 게시판 글 수정시 해당 내용을 수정해주는 메소드
	public int boardUpdate(BoardDTO dto);
	
	// 6. 게시판 글 삭제를 해주는 기능의 메소드
	public int boardDelete(int id);
	
}
