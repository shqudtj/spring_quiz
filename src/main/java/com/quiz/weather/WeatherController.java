package com.quiz.weather;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather.bo.WeatherHistoryBO;
import com.quiz.weather.domain.WeatherHistory;

@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 목록 화면
	@GetMapping("/weather_history_view")
	public String weatherHistoryView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "weather/weatherHistory";
	}
	
	@GetMapping("/add_weather_view")
	public String addWeatherView() {
		return "weather/addWeather";
	}
	
	// 날씨 insert
	@PostMapping("/add_weather")
	public String addWeather(
			// requestparam이 너무 많으면 하나하나씩 디버그를 걸어 확인하는게좋음
			@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			// date를 Date를 하지않고 String으로 해도 DB에서는 Date로 인식을함
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed
			
			// HttpServletResponse response
			) {

		// insert DB
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		
		// response.sendRedirect("/weather/weather_history_view");
		return "redirect:/weather/weather_history_view"; // 새 request 수행
	}
	
}







