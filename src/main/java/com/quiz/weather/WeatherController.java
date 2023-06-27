package com.quiz.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	// 목록 화면
	@GetMapping("/weather_history_view")
	public String weatherHistoryView() {
		return "weather/weatherHistory";
	}
	
	@GetMapping("/add_weather_view")
	public String addWeatherView() {
		return "weather/addWeather";
	}
}
