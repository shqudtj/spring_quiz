package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.dao.RealEstateMapper;
import com.quiz.lesson03.domain.RealEstate;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;  
	
	// input: id
	// output: RealEstate => 컨트롤러 한테
	public RealEstate getRealEstateById(int id) { // 여기서 id 는 BO의 기준이므로 반드시 null이 아닌것이 오기 때문에 int
		return realEstateMapper.selectRealEstateById(id);
	}
	
	public List<RealEstate> getRealEstateByRentPriceList(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPriceList(rentPrice);
	}
	
	public List<RealEstate> getRealEstatesByAreaPriceList(int area, int price) {
		return realEstateMapper.selectRealEstatesByAreaPriceList(area, price);
	}
}
