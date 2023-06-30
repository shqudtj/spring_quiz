package com.quiz.pension;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.pension.bo.BookingBO;
import com.quiz.pension.domain.Booking;

@RequestMapping("/pension")
@Controller
public class PensionController {

	@Autowired
	private BookingBO bookingBO;
	
	@RequestMapping("/pension_reservation_view")
	public String pesionReservationView(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList(); 
		model.addAttribute("bookingList", bookingList);
		
		return "pension/pensionReservation";
	}
}
