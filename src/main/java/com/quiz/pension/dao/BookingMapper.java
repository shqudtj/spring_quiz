package com.quiz.pension.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.pension.domain.Booking;

@Repository
public interface BookingMapper {

	public List<Booking> selectBookingList();
	
	public int deleteBookingById(int id);
}
