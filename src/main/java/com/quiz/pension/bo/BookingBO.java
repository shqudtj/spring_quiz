package com.quiz.pension.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.pension.dao.BookingMapper;
import com.quiz.pension.domain.Booking;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public int addPensionReservation(String name, String date, int day, int headcount, String phoneNumber) {
		return bookingMapper.insertPensionReservation(name, date, day, headcount, phoneNumber);
	}
	
	public Booking getBooking(int id) {
		return bookingMapper.selectBookingById(id);
	}
	
	public Booking searchBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		// 가능한 값 : [], [bookingA, bookingB,  ...]
		List<Booking> bookingList = bookingMapper.selectBookingByNameAndPhoneNumber(name, phoneNumber);
		if (bookingList.isEmpty()) {
			return null;
		}
		
		return bookingList.get(bookingList.size()-1);	// 마지막 값을 준다. => (최신 예약)
	}
	
}
