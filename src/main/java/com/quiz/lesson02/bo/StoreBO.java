package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.dao.StoreMapper;
import com.quiz.lesson02.domain.Store;

@Service // Spring Bean 으로 만듦
public class StoreBO {

	// 필드
	@Autowired
	private StoreMapper storeMapper;
	
	// input: x
	// output: List<Store>
	public List<Store> getStoreList() {
		List<Store> storeList = storeMapper.selectStoreList();
		return storeList;
	}
}
