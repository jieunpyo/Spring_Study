package com.spring.mvc.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
//	 /form 의 get 방식의 url 요청이 오면 views 의 student 폴더안에 
//	 studentForm.jsp 파일을 실행하도록 하는 메소드를 만든다.
	
	@GetMapping("/form")
	public String studentForm() {
		return "student/studentForm";
	}
	
//	 /data 의 post 방식의 url 요청이 오면 넘어오는 데이터를 
//	 Student 객체에 바인딩을 받아 Model 객체에 Student 객체를 담은 다음 
//	 views 의 student 폴더안에 studentData.jsp 파일을 실행시키는 메소드를 만든다.
	
	@PostMapping("data")
	public String studentData(Student student, Model model) {
		
		model.addAttribute("student", student);
		
		return "student/studentData";
	}
	
	
}








