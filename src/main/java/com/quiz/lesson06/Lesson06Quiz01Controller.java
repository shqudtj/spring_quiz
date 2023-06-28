package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {

	@Autowired
	private BookmarkBO bookmarkBO;
	
	@GetMapping("/add_bookmark_view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	@PostMapping("/add_bookmark")
	@ResponseBody
	public String addBookmark(
			@RequestParam("title") String title,
			@RequestParam("address") String address
			) {
		bookmarkBO.addBookmark(title, address);
		
		return "성공";
	}
	
	@GetMapping("/after_add_bookmark_view")
	public String afterAddBookmarkView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model
			) {
		
		Bookmark bookmark = null;
		// 마지막 db select
		if (id == null) {
			bookmark = bookmarkBO.getLatestBookmark();
		} else {
			bookmark = bookmarkBO.getBookmarkById(id);
		}
		
		model.addAttribute("bookmark", bookmark);
		
		return "lesson06/afterAddBookmark";
	}
	
}
