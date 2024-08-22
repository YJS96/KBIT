package org.example.dto.weather;

import lombok.Data;

import java.util.List;

@Data
public class WeatherDto {
    private Coord coord;
    private List<WeatherItem> weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
}
