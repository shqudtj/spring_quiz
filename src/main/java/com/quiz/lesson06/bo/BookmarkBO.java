package com.quiz.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.BookmarkMapper;
import com.quiz.lesson06.domain.Bookmark;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public void addBookmark(String title, String address) {
		bookmarkMapper.insertBookmark(title, address);
	}
	
	public Bookmark getLatestBookmark() {
		return bookmarkMapper.selectLatestBookmark();
	}
	
	public Bookmark getBookmarkById(int id) {
		return bookmarkMapper.selectBookmarkById(id);
	}
}
