package com.spring.web.board.service;

import java.util.List;

import org.springframework.ui.Model;

import com.spring.web.board.dto.BoardDTO;
import com.spring.web.board.search.SearchVO;

public interface BoardService {
	
	public List<BoardDTO> boardList(Integer page, SearchVO search, Model model);

	public int write(BoardDTO dto);

	public BoardDTO getContent(Integer id);

	public void upViewCount(Integer id);

	public int boardUpdate(BoardDTO dto);

	public int boardDelete(Integer id);
	
}
