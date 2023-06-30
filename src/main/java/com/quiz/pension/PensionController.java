package com.quiz.pension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@DeleteMapping("/delete_booking")
	@ResponseBody
	public Map<String, Object> deleteBooking(
				@RequestParam("bookingId") int id
			) {
		
		// db delete
		int row = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (row == 1) { // 성공일때
			result.put("code", 1);
			result.put("result", "성공");
		} else { // 삭제된 행이 없음 -> 실패
			result.put("code", 500);
			result.put("result", "삭제될 데이터가 없습니다");
		}
		
		return result;
	}
	
}
