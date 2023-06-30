package com.quiz.pension.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.pension.dao.BookingMapper;
import com.quiz.pension.domain.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
}
