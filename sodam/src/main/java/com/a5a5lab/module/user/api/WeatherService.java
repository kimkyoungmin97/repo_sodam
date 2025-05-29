package com.a5a5lab.module.user.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
                String dtTxt = item.getString("dt_txt"); // UTC: "2024-06-01 12:00:00"

                // 1. UTC -> KST 변환
                LocalDateTime utcDateTime = LocalDateTime.parse(dtTxt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                ZonedDateTime kstDateTime = utcDateTime.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Seoul"));

                String kstDate = kstDateTime.toLocalDate().toString(); // 변환된 날짜: yyyy-MM-dd
                String kstHour = String.format("%02d", kstDateTime.getHour()); // 시각: HH

                // 2. 정오(KST 12:00) 기준 예보만 필터링
                if (!dateToWeather.containsKey(kstDate) && "12".equals(kstHour)) {
                    JSONObject main = item.getJSONObject("main");
                    JSONArray weatherArr = item.getJSONArray("weather");
                    JSONObject weatherObj = weatherArr.getJSONObject(0);

                    WeatherDto dto = new WeatherDto();
                    dto.setDateString(kstDate); // 컨트롤러에서 SimpleDateFormat으로 변환
                    dto.setTemperature(main.getDouble("temp"));
                    dto.setWeatherIcon(weatherObj.getString("icon"));
                    dto.setDescription(weatherObj.getString("description"));

                    dateToWeather.put(kstDate, dto);
                }
            }

            result.addAll(dateToWeather.values());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
