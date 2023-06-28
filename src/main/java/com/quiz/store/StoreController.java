package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RequestMapping("/store")
@Controller
public class StoreController {

	@Autowired
	private StoreBO storeBO;
	
	@GetMapping("/store_view")
	public String storeView(Model model) {
		List<Store> storeList = storeBO.getStoreList(); 
		
		model.addAttribute("storeList", storeList);
		
		return "store/storeView";
	}
	
//	@GetMapping("/reviews")
//	public String reviews(
//			@RequestParam("storeId") int storeId,
//			@RequestParam("storeName") String storeName
//			) {
//		List<Review> reviewList = store
//		
//		
//		return "store/review";
//	}
}
