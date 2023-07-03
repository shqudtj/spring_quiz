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
	// AJAX가 하는 요청
	@DeleteMapping("/delete_booking")
	@ResponseBody
	public Map<String, Object> deleteBooking(
				@RequestParam("bookingId") int id
			) {
		
		// db delete
		int row = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) { // 성공일때
			result.put("code", 1);
			result.put("result", "성공");
		} else { // 삭제된 행이 없음 -> 실패
			result.put("code", 500);
			result.put("errorMessage", "삭제될 데이터가 없습니다");
		}
		
		return result;
	}
	
	// 예약 하기 화면
	@RequestMapping("/pensionReservation_view")
	public String pensionReservationView() {
		
		return "pension/pensionReservation";
	}
	
	// 예약하기
	// AJAX가 하는 요청
	@PostMapping("/pensionReservation")
	@ResponseBody
	public Map<String, Object> addPensionReservation(
			@RequestParam("name") String name,
			@RequestParam("date") String date, // @DateTimeFormat을 붙이고(dao에) Date 객체로 받아와도 된다.
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			) {

		// insert
		int row = bookingBO.addPensionReservation(name, date, day, headcount, phoneNumber);
		
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		//result.put("result", "성공");
		
		if (row > 0) {
			result.put("result", "성공");
			result.put("code", 1);
		} else {
			result.put("errorMessage", "예약 데이터가 추가되지 못했습니다.");
			result.put("code", 500);
		}
		
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
	@ResponseBody
	public Map<String, Object> searchBooking(
				@RequestParam("name") String name,
				@RequestParam("phoneNumber") String phoneNumber
			) {
		
		// select DB
		Booking booking = bookingBO.searchBookingByNameAndPhoneNumber(name, phoneNumber);
		
		// 응답 JSON
		Map<String, Object> result = new HashMap<>();
		if (booking == null) {
			result.put("code", 300);
			result.put("errorMessage", "예약 내역이 없습니다.");
		} else {
			result.put("code", 1);
			result.put("booking", booking);
		}
		
		return result;
	}
	
}




 