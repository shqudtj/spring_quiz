package com.quiz.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(@Param("id") int id); 
	// @Param("") "" 안의 이름을 xml의 쿼리문에서 인식함
	
	
	public List<RealEstate> selectRealEstateByRentPriceList(int rentPrice);
	
	public List<RealEstate> selectRealEstatesByAreaPriceList(@Param("area") int area, @Param("price") int price);
	// 파라미터가 2개이상일때는 @Param("")을 붙여줘야함
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price
			);
	
	public int deleteRealEstateById(int id);
}
