package com.a5a5lab.module.user.api;

import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	private final String apiKey = "df06aa95a8aa48bc552403a824b3e8bc";

	public List<WeatherDto> get5DayForecast(double lat, double lon) {
        List<WeatherDto> result = new ArrayList<>();
        try {
            String urlStr = String.format(
                "https://api.openweathermap.org/data/2.5/forecast?lat=%f&lon=%f&appid=%s&units=metric",
                lat, lon, apiKey
            );

            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonSB = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonSB.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(jsonSB.toString());
            JSONArray list = json.getJSONArray("list");

            Map<String, WeatherDto> dateToWeather = new LinkedHashMap<>();

            for (int i = 0; i < list.length(); i++) {
                JSONObject item = list.getJSONObject(i);
                String dtTxt = item.getString("dt_txt"); // "2024-06-01 12:00:00"
                String date = dtTxt.split(" ")[0];

                if (!dateToWeather.containsKey(date) && dtTxt.contains("12:00:00")) {
                    JSONObject main = item.getJSONObject("main");
                    JSONArray weatherArr = item.getJSONArray("weather");
                    JSONObject weatherObj = weatherArr.getJSONObject(0);

                    WeatherDto dto = new WeatherDto();
                    dto.setDate(date);
                    dto.setTemperature(main.getDouble("temp"));
                    dto.setWeatherIcon(weatherObj.getString("icon")); // ex: 10d
                    dto.setDescription(weatherObj.getString("description"));

                    dateToWeather.put(date, dto);
                }
            }

            result.addAll(dateToWeather.values());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
