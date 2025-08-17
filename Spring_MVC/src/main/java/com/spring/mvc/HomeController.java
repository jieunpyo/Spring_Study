package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
// 스프링이 관리하는 빈객체로 등록하기 위한 설정
// 해당 클래스가 Controller 의 역할을 한다고 명시하는 어노테이션
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// @RequestMapping : ContextPath 다음에 해당하는 url과
	//					 해당하는 메소드의 요청방식으로 요청이 들어오면 메소드를 실행
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println("home 메소드 입니다.");
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// 문자열로 뷰이름을 반환하면 그것을 디스패쳐 서블릿이 뷰리졸버한테 호출을 하면서 뷰이름을 준다.
		// 뷰리졸버는 클라이언트한테 실제로 응답해줄 자원의 경로로 바꾸어준다.
	}
	
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		System.out.println("hello 메소드 입니다.");
		return "hello";
		// WEB-INF 폴더의 views 폴더의 확장자를 제외한 
		// jsp 파일을 이름을 문자열로 반환해준다.
	}
	
	
	
	
}

















