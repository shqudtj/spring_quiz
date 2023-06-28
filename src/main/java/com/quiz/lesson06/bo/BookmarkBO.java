package com.quiz.lesson06.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public void addBookmark(String title, String address) {
		bookmarkMapper.insertBookmark(title, address);
	}
	
	public getLatestBookmark() {
		reutn bookmarkMapper.selectBookmark(id);
	}
}
