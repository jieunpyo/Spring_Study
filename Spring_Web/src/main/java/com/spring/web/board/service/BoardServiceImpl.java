package com.spring.web.board.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.web.board.dto.BoardDTO;
import com.spring.web.board.mapper.BoardMapper;
import com.spring.web.board.paging.Paging;
import com.spring.web.board.search.SearchVO;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	
	@Override
	public List<BoardDTO> boardList(Integer page, SearchVO search, Model model) {
		
		int totalCount = mapper.totalCount(search.getSearchWord(), search.getKey());
		
		Paging paging = new Paging(totalCount, page);
		
		// 현재 페이지가 1페이지 라면 시작은1 끝은 10
		
		int postStart = ((paging.getCurrentPage() -1) * 10) + 1;
		
		int postEnd = paging.getCurrentPage() * 10;
		
		model.addAttribute("paging", paging);
		
		List<BoardDTO> list = mapper.boardList(search.getSearchWord(), search.getKey(), postStart, postEnd);
		
		// list안에 DTO 객체에 newMark 를 현재시간과 등록일을 계산(24시간이 지났는지 확인)
		// 24시간이 지나지 않았다면 newMark를 true로 설정
		
		for(BoardDTO dto : list) {
			
			long nowTime = System.currentTimeMillis();
			
			Timestamp regDate = dto.getRegDate();
			
			long regTime = regDate.getTime();
			
			if((nowTime - regTime) < (1000 * 60 * 60 * 24)) {
				dto.setNewMark(true);
			}
			
			
		}
		
		
		return list;
	}

	@Override
	public int write(BoardDTO dto) {
		
		int result = 0;
		
		if(dto != null) {
			
			result = mapper.write(dto);
			
		}
		
		return result;
	}

	@Override
	public BoardDTO getContent(Integer id) {
		
		if(id != null) {
			upViewCount(id);
			return mapper.getContent(id);
		}else {
			return null;
		}
		
	}

	@Override
	public void upViewCount(Integer id) {
		
		mapper.upViewCount(id);

	}

	@Override
	public int boardUpdate(BoardDTO dto) {
		
		if(dto != null) {
			return mapper.boardUpdate(dto);
		}else {
			return 0;
		}
		
	}

	@Override
	public int boardDelete(Integer id) {
		
		if(id != null) {
			return mapper.boardDelete(id);
		}else {
			return 0;
		}
		
	}

}

