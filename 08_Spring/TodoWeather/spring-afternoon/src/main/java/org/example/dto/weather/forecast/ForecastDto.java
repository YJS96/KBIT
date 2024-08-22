package org.example.dto.weather.forecast;

import lombok.Data;

import java.util.List;

@Data
public class ForecastDto {
    private String cod;
    private String message;
    private Long cnt;
    private List<ListItem> list;
    private City city;
}
