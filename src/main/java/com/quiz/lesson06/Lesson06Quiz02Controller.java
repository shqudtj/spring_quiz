package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {

	@GetMapping("/add_bookmark_view2")
	public String addBookmarkView2() {
		return "lesson06/addBookmark2";
	}
	
	
	
	
}
