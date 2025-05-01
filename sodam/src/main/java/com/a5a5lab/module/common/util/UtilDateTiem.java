package com.a5a5lab.module.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilDateTiem {
	
	public static String addNowTimeString(String date) {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		return date + " " + localDateTimeString;
	}
	
	
	public static String add00TimeString(String date) {
		return date + " 00:00:00";
	}

	
	public static String add59TimeString(String date) {
		return date + " 23:59:59";
	}


	public static String nowString() {
		// TODO Auto-generated method stub
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	
	
	
	
}
