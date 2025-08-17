package com.spring.mvc.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {
	
	@GetMapping("/form01")
	public String form01() {
		return "param/form01";
	}
	
	@PostMapping("/data1")
	public String data1(HttpServletRequest request) throws Exception {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		return "param/data";
		
	}
	
	@GetMapping("/form02")
	public String form02() {
		return "param/form02";
	}
	
	// @RequestParam 어노테이션을 사용하여 
	// 넘어오는 파라미터의 값을 해당 변수에 바인딩할수 있다.
	// 필수가 아닌 파라미터의 경우에는 어노테이션의 속성으로 
	// required=false 로 설정을 해주면 
	// 넘어오는 파라미터의 데이터가 없는경우나, 또는 빈 문자열을 경우에
	// 예외를 발생시키지 않고, null 값이 변수에 저장 되어진다.
	
	@PostMapping("/data2")
	public String data2(@RequestParam("id")String id, 
						@RequestParam("pw")String pw,
						@RequestParam(value="name", required=false)String name, 
						@RequestParam(value="age", required=false, defaultValue="20")Integer age,
						Model model) {
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		// Model : Controller에서 생성한 데이터를 view 페이지로 전달할때 사용되는 객체
		// addAttribute("key", value) 메소드를 사용하여 데이터를 셋팅
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "param/data";
	}
	
	// 스프링에서 HttpServletRequest 를 통해 전송정보를 얻을 수도 있고,
	// @RequestParam 어노테이션으로 데이터를 해당 매개변수에 바인딩하여 전송정보를 얻을 수도 있다.
	// 하지만 이 두 방식은 파라미터 갯수들이 많아지면 하나하나 명시를 하여 처리해야 되어 
	// 가독성이 떨어지는 등의 단점이 있다.
	// 따라서 스프링은 커맨드 객체(Command Object)를 지원하고 있다.
	// http 요청 파라미터의 이름을 사용한 setter 메소드를 작성한 클래스를 만들고
	// 이 클래스의 객체(커맨드 객체)를 메소드의 매개변수에 작성을 해주면
	// 파라미터의 값들이 객체의 속성값으로 자동으로 바인딩 되어 전송정보를 얻을 수 있다.
	
	
	@GetMapping("/form03")
	public String form03() {
		return "param/form03";
	}
	
	@PostMapping("/data3")
	public String data3(@ModelAttribute("member")Member member, Model model) {
		
		//model.addAttribute("member", member);
		
		return "param/data";
	}
	
}








