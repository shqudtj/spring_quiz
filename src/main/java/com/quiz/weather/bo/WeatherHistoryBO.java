package com.quiz.weather.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather.dao.WeatherHistoryMapper;
import com.quiz.weather.domain.WeatherHistory;

@Service
public class WeatherHistoryBO {

	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	public List<WeatherHistory> getWeatherHistoryList() {
		
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	public void addWeatherHistory(Date date, String weather, String microDust, double temperatures,
			 double precipitation, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
	
}
