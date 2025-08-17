package com.spring.db.board.service;

import java.util.List;

import com.spring.db.board.dto.BoardDTO;

public interface BoardService {

	public List<BoardDTO> boardList();

	public int write(BoardDTO dto);

	public BoardDTO getContent(Integer id);

	public void upViewCount(Integer id);

	public int boardUpdate(BoardDTO dto);

	public int boardDelete(Integer id);

}
