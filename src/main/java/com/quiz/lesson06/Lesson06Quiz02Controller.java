package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;

	// 즐겨찾기 추가 화면
	@GetMapping("/add_bookmark_view2")
	public String addBookmarkView2() {
		return "lesson06/addBookmark2";
	}
	
	
	@PostMapping("/add_bookmark2")
	@ResponseBody
	public Map<String, Object> addBookmark2(
			@RequestParam("name") String name,
			@RequestParam("url") String url
			) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		
		// 응답
		// {"code":1, "result":"성공"}	JOSN String
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		
		return result;
	}
	
	@PostMapping("/delete_bookmark")
	@ResponseBody
	public Map<String, Object> deleteBookmark(
			@RequestParam("name") String name
			) {
		
		// db delete
		bookmarkBO.deleteBookmark(name);
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		
		return result;
	}
	
	
	
	// 즐겨찾기 목록 화면
	@GetMapping("/after_add_bookmark_view2")
	public String afterAddBookmarkView2(
			Model model
			) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		model.addAttribute("bookmarkList", bookmarkList);

		
		
		return "lesson06/afterAddBookmark2";
	}
	
	
}
