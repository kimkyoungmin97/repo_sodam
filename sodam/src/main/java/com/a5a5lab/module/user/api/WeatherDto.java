package com.a5a5lab.module.user.api;

import java.util.Date;

public class WeatherDto {
	private double currentTemperature;
    private int currentHumidity;
    private double forecastTemperature;
    private int forecastHumidity;
    private double rainfall;
    private double precipitation;
    
    private String dateString; // 원본 문자열 날짜
    private Date date;         // 변환된 Date 객체
    private double temperature;
    private String weatherIcon; // ex: "10d", "01n"
    private String description; // ex: "clear sky"
    
    
    
//-----
    
    
	public double getCurrentTemperature() {
		return currentTemperature;
	}
	 public void setDate(String dateString) {
	        this.dateString = dateString;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public String getDateString() {
	        return dateString;
	    }

	    public Date getDate() {
	        return date;
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
	public void setCurrentTemperature(double currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
	public int getCurrentHumidity() {
		return currentHumidity;
	}
	public void setCurrentHumidity(int currentHumidity) {
		this.currentHumidity = currentHumidity;
	}
	public double getForecastTemperature() {
		return forecastTemperature;
	}
	public void setForecastTemperature(double forecastTemperature) {
		this.forecastTemperature = forecastTemperature;
	}
	public int getForecastHumidity() {
		return forecastHumidity;
	}
	public void setForecastHumidity(int forecastHumidity) {
		this.forecastHumidity = forecastHumidity;
	}
	public double getRainfall() {
		return rainfall;
	}
	public void setRainfall(double rainfall) {
		this.rainfall = rainfall;
	}
	public double getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}
    
    
}
