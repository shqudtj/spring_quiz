package com.quiz.pension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	// 예약 목록 보기 화면
	@RequestMapping("/pension_reservationList_view")
	public String pesionReservationListView(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList(); 
		model.addAttribute("bookingList", bookingList);
		
		return "pension/pensionReservationList";
	}
	
	// 예약 삭제
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
	
	// 예약 하기 화면
	@RequestMapping("/pensionReservation_view")
	public String pensionReservationView() {
		
		return "pension/pensionReservation";
	}
	
	// 예약하기
	@PostMapping("/pensionReservation")
	@ResponseBody
	public Map<String, Object> addReservationBooking(
			@ModelAttribute Booking booking,
			Model model
			) {

		bookingBO.addReservationBooking(booking);
		model.addAttribute("booking", model);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "성공");
		
		return result;
	}
	
	
//	public Map<String, Object> addReservationBooking(
//				@ModelAttribute Booking booking,
//				Model model
//			) {
//		
//		bookingBO.addReservationBooking(booking);
//		Booking newBooking = bookingBO.selectBookingById(booking.getId());
//		
//		model.addAttribute("booking", newBooking);
//		
//		Map<String, Object> result = new HashMap<>();
//		result.put("result", "성공");
//		
//		return result;
//	}
	
	
	// 예약 조회
	
	@GetMapping("/search_booking_view")
	public String searchBookingView() {
		
		return "pension/searchBooking";
	}
	
	@PostMapping("/searchBooking")
	public Map<String, Object> searchBooking(
				@RequestParam("name") String name,
				@RequestParam("phoneNumber") int phoneNumber
			) {
		
		bookingBO.searchBooking(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		
		return result;
	}
	
}




