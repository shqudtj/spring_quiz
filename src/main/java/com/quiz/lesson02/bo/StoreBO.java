package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.domain.Store;

@Service // java bean을 Spring Bean 으로 만듦
public class StoreBO {

	// 필드
	@Autowired
	private StoreMapper storeMapper;  // spring bean을 주입받는다. DI
	
	// input: x
	// output: List<Store> 즉 storeList	=> 컨트롤러한테 돌려준다.
	public List<Store> getStoreList() {
		// List<Store> storeList = storeMapper.selectStoreList();
		// return storeList;
		return storeMapper.selectStoreList();
	}
}
