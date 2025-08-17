package com.spring.db.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.db.board.dao.BoardDAO;
import com.spring.db.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("dao2")
	private BoardDAO dao;
	
	
	@Override
	public List<BoardDTO> boardList() {
		
		return dao.boardList();
	}

	@Override
	public int write(BoardDTO dto) {
		
		int result = 0;
		
		if(dto != null) {
			
			result = dao.write(dto);
			
		}
		
		return result;
	}

	@Override
	public BoardDTO getContent(Integer id) {
		
		if(id != null) {
			upViewCount(id);
			return dao.getContent(id);
		}else {
			return null;
		}
		
	}

	@Override
	public void upViewCount(Integer id) {
		
		dao.upViewCount(id);

	}

	@Override
	public int boardUpdate(BoardDTO dto) {
		
		if(dto != null) {
			return dao.boardUpdate(dto);
		}else {
			return 0;
		}
		
	}

	@Override
	public int boardDelete(Integer id) {
		
		if(id != null) {
			return dao.boardDelete(id);
		}else {
			return 0;
		}
		
	}

}
