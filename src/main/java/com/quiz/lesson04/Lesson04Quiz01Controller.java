package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// 판매자 추가 페이지
	// http://localhost:8080/lesson04/quiz01/add_seller_view
	@GetMapping("/add_seller_view")
	public String addSellerView() {
		
		return "lesson04/addSeller";
	}
	
	// 추가 action
//	http://localhost:8080/lesson04/quiz01/add_seller
	@PostMapping("/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profile_image_url", required = false) String profileImageUrl,
			// value 라고 쓰는 이유는 db에 null(비필수)라고 지정해놓아서
			// 위 행위를 하지 않으면 "" 즉 빈 공간이 나옴
			@RequestParam("temperature") double temperature
			) {
		
		// db insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 입력 성공 페이지
		return "lesson04/afterAddSeller";
	}

	// 최근 가입자 정보 페이지
//	http://localhost:8080/lesson04/quiz01/seller_info
	@GetMapping("/seller_info")
	public String sellerInfo(
			@RequestParam(value = "id", required = false) Integer id,
			Model model
			) {
		
		Seller seller = null;
		
		if (id == null) {
			// 최근 가입자 db select
			seller = sellerBO.getLatestSeller();
		} else {
			// id가 있는 경우
			seller = sellerBO.getSellerById(id);
		}
		model.addAttribute("seller", seller);
		return "lesson04/sellerInfo";
		
	}
	
	
	// http://localhost:8080/lesson04/quiz01/seller_info?id=1
//	@GetMapping("/seller_info")
//	public String sellerInfoById(
//				@RequestParam("id") int id
//			) {
//		
//		
//		return "lesson04/sellerInfoById";
//	}
//	
}
