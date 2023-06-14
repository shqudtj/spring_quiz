package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {

	// http://localhost:8080/lesson01/quiz03/1
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03_1() {
		// @ResponseBody가 아닌 @Controller인 상태로 String 리턴하면
		// ViewResolver 클래스에 의해 리턴된 String의 view(jsp) 경로를 찾아 수행한다.
		// => 스프링파트의 동작방식의 그림을 보면 됨
		
		//	/WEB-INF/jsp/	.jsp 까지 세팅을 이미 해놓음 (resource 폴더의 application properties 안에)
		return "lesson01/quiz03";  // ""시작에 / 없이 시작인거 까먹지 않기
	}
}
