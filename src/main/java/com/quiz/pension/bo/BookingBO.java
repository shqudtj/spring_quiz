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
	
//	@RequestParam("name") String name,
//	@RequestParam("date") String date,
//	@RequestParam("day") int day,
//	@RequestParam("headcount") int headcount,
//	@RequestParam("phoneNumber") String phoneNumber,
	public void addReservationBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertReservationBooking(name, date, day, headcount, phoneNumber);
	}
	
	public Booking getBooking(int id) {
		return bookingMapper.selectBookingById(id);
	}
	
	public void searchBooking(String name, String phoneNumber) {
		bookingMapper.selectBooking(name, phoneNumber);
	}
	
}
