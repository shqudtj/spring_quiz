package com.quiz.lesson04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {

//	http://localhost/lesson04/quiz01/add_seller_view
	@PostMapping("/add_seller_view")
	public String addSellerView() {
		
		return "lesson04/addSeller";
	}
	
	
}
