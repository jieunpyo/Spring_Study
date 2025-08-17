package com.spring.mvc.animal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal") // 공통 url
public class AnimalController {
	
	@GetMapping("/cat")
	public String cat() {
		return "animal/cat";
	}
	
	@GetMapping("/dog")
	public String dog() {
		return "animal/dog";
	}
	
	@GetMapping("/duckForm")
	public String duckForm() {
		return "animal/duckForm";
	}
	
	@PostMapping("/duck")
	public String duck() {
		return "animal/duck";
	}
	
}
