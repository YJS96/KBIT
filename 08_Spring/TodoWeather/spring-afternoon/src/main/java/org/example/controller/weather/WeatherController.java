package org.example.controller.weather;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.weather.WeatherDto;
import org.example.dto.weather.forecast.ForecastDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequiredArgsConstructor
@Transactional
@RequestMapping("/weather")
@CrossOrigin(origins = "*")
public class WeatherController {
    private static final String apiKey = "38ab20446a1b57ab9ccaa7f3640b15ec";
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&APPID={apiKey}&lang=kr";
    private static final String FORECAST_URL = "https://api.openweathermap.org/data/2.5/forecast?q={city}&units=metric&APPID={apiKey}&lang=kr";

    @GetMapping("/{cityname}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable("cityname") String cityname) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            WeatherDto weatherDto = restTemplate.getForObject(WEATHER_URL, WeatherDto.class, cityname, apiKey);
            return ResponseEntity.ok(weatherDto);
        } catch (Exception e) {
            log.error("날씨 정보 불러오기 오류");
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/forecast/{cityname}")
    public ResponseEntity<ForecastDto> getForecast(@PathVariable("cityname") String cityname) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ForecastDto forecastDto = restTemplate.getForObject(FORECAST_URL, ForecastDto.class, cityname, apiKey);
            System.out.println(forecastDto);
            return ResponseEntity.ok(forecastDto);
        } catch (Exception e) {
            log.error("예보 정보 불러오기 오류");
            return ResponseEntity.internalServerError().build();
        }
    }
}
