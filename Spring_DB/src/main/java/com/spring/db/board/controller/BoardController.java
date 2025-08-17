package com.spring.db.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.db.board.dto.BoardDTO;
import com.spring.db.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 게시판 목록 페이지 요청
	@GetMapping("/list")
	public String boardList(Model model) {
		
		List<BoardDTO> list = service.boardList();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	// 글 작성 폼 페이지 요청
	@GetMapping("/write")
	public String writeForm() {
		return "board/writeForm";
	}
	
	// 글작성 후 글 등록 요청
	
	@PostMapping("/write")
	public String write(BoardDTO dto, RedirectAttributes ra) {
		
		int result = service.write(dto);
		
		if(result == 1) {
			ra.addFlashAttribute("msg", "글이 등록되었습니다.");
			return "redirect:/board/list";
		}else {
			ra.addFlashAttribute("msg", "글이 등록되지 않았습니다.");
			return "redirect:/board/write";
		}
		
	}
	
	// 목록에서 제목클릭시 해당 내용을 보여주는 페이지 요청
	@GetMapping("/contentView")
	public String contentView(@RequestParam("id")Integer id, Model model) {
		
		BoardDTO dto = service.getContent(id);
		
		model.addAttribute("contentView", dto);
		
		return "board/contentView";
	}
	
	// 글 수정 폼 페이지 요청
	@PostMapping("/modifyForm")
	public String modifyForm() {
		return "board/modifyForm";
	}
	
	
	// 글 수정 요청
	@PostMapping("/modify")
	public String modify(BoardDTO dto, RedirectAttributes ra) {
		
		int result = service.boardUpdate(dto);
		
		if(result == 1) {
			
			ra.addFlashAttribute("msg", "글이 수정되었습니다.");
			
		}else {
			ra.addFlashAttribute("msg", "글이 수정되지 않았습니다.");
		}
		
		return "redirect:/board/contentView?id=" + dto.getId();
		
	}
	
	
	// 글 삭제 요청
	@PostMapping("/delete")
	public String delete(@RequestParam("id")Integer id, RedirectAttributes ra) {
		
		int result = service.boardDelete(id);
		
		if(result == 1) {
			ra.addFlashAttribute("msg", "글이 삭제되었습니다.");
		}else {
			ra.addFlashAttribute("msg", "글이 삭제되지 않았습니다.");
		}
		
		return "redirect:/board/list";
	}
	
}










