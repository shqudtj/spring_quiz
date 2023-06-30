package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	// ajax가 하는 요청 - url 중복확인
	@ResponseBody
	@PostMapping("/is_duplication_url")
	public Map<String, Object> isDuplicationUrl(
			@RequestParam("url") String url
			) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("isDuplication", false);
		
		// db select by url
		Bookmark bookmark = bookmarkBO.getBookmarkByUrl(url);	// bookmark or null
		if (bookmark != null) {	// 중복
			result.put("isDuplication", true);
		}
		
		return result;
	}
	
	
	// AJAX가 하는 요청 - 즐겨찾기 삭제
	@DeleteMapping("/delete_bookmark")
	@ResponseBody
	public Map<String, Object> deleteBookmark(
			@RequestParam("bookmarkId") int id 
			) {
		
		// db delete
		int row = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (row == 1) {
			// 성공
			result.put("code", 1);
			result.put("result", "성공");
			
		} else {
			// 삭제된 행이 없음 - 실패
			result.put("code", 500);
			result.put("errorMessage", "삭제될 데이터가 없습니다.");
		}
		
		return result;
	}

	
	
	// 내가 한것
//	@PostMapping("/delete_bookmark")
//	@ResponseBody
//	public Map<String, Object> deleteBookmark(
//			@RequestParam("name") String name
//			) {
//		
//		// db delete
//		bookmarkBO.deleteBookmarkByName(name);
//		
//		// 응답
//		Map<String, Object> result = new HashMap<>();
//		result.put("code", 1);
//		result.put("result", "성공");
//		
//		return result;
//	}
	
	
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
