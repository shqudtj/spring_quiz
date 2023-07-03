package com.quiz.pension.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.pension.domain.Booking;

@Repository
public interface BookingMapper {
	
	
	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
	
	public int insertPensionReservation(
			@Param("name") String name, 
			@Param("date") String date,
			@Param("day") int day,
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public Booking selectBookingById(int id);
	
	public List<Booking> selectBookingByNameAndPhoneNumber(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
}
