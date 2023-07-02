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
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	public void addReservationBooking(Booking booking) {
		bookingMapper.insertReservationBooking(booking);
	}
	
	public Booking getBooking(int id) {
		return bookingMapper.selectBookingById(id);
	}
	
	public void searchBooking(String name, int phoneNumber) {
		bookingMapper.selectBooking(name, phoneNumber);
	}
	
}
