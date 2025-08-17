package com.spring.mvc.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
	
	// get 방식의 /aaa 라는 url로 요청이 들어오면 
	// 해당 메소드 실행
	//@RequestMapping(value="/aaa", method=RequestMethod.GET)
	@GetMapping("/aaa")
	public String aaa() {
		
		System.out.println("aaa 메소드 입니다.");
		
		return "page/aaa";
		// WEB-INF 폴더의 views 폴더안에 확장자를 제외한 
		// jsp 파일을 이름을 문자열로 반환해준다.
	}
	
	//@RequestMapping(value="/form", method=RequestMethod.GET)
	@GetMapping("/form")
	public String formEx() {
		
		return "page/pageForm";
		
	}
	
	// action="/mvc/post" method="post"
	//@RequestMapping(value="/post", method=RequestMethod.POST)
	@PostMapping("/post")
	public String formOK() {
		System.out.println("formOK 메소드 입니다.");
		return "page/formOK";
	}
	
	
}








