package org.example.dto.weather.forecast;

import java.util.List;
import lombok.Data;

@Data
public class Response{
	private City city;
	private int cnt;
	private String cod;
	private int message;
	private List<ListItem> list;
}