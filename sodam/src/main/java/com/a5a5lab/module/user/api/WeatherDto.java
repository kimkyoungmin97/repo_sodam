package com.a5a5lab.module.user.api;

import java.util.Date;

public class WeatherDto {
	private String dateString; 
	private Date date;         
	private double temperature;
	private String weatherIcon;
	private String description;
//	----
	public String getDateString() {
		return dateString;
	}

	 public void setDate(String dateString) {
        this.dateString = dateString;
    }
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getWeatherIcon() {
		return weatherIcon;
	}
	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
    
    
//-----
    
    
	
    
    
}
