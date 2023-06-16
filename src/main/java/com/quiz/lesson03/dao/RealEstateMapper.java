package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(@Param("id") int id); // @Param("") "" 안의 이름을 xml의 쿼리문에서 인식함
	
	
	public List<RealEstate> selectRealEstateByRentPriceList(int rentPrice);
	
	public List<RealEstate> selectRealEstatesByAreaPriceList(@Param("area") int area, @Param("price") int price);
	// 파라미터가 2개이상일때는 @Param("")을 붙여줘야함
}
