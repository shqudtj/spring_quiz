package com.quiz.lesson06.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.Bookmark;

@Repository
public interface BookmarkMapper {

	public void insertBookmark(
			@Param("title") String title,
			@Param("address") String address);
		
	public Bookmark selectLatestBookmark();
	
	public Bookmark selectBookmarkById(int id);
}
