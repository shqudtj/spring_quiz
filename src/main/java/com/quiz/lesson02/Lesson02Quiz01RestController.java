package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController // => @Controller + @ResponseBody -> Spring bean으로 만듦 
public class Lesson02Quiz01RestController {

	@Autowired
	private StoreBO storeBO;
	
	// http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
    // 이 부분에서 import할때 store도메인을 만들기 전이면 아파치임포트가 되기 때문에 store 도메인을 만들고 나서 하자		
		List<Store> storeList = storeBO.getStoreList();
		return storeList;
	}
	
}
