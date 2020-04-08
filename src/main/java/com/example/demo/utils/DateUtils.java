package com.example.demo.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.datetime.DateFormatter;

public class DateUtils {
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_TIME_FORMAT_FILE_NAME = "yyyyMMddHHmmss";
	
	private DateUtils() {
		throw new IllegalStateException("Date Utils class");
	}
	public static String toString(Date date) {
		DateFormatter formatter = new DateFormatter(DATE_TIME_FORMAT);
		return formatter.print(date, Locale.getDefault());
	}
	
	public static Date parseToDate(String text) throws ParseException {
		DateFormatter formatter = new DateFormatter(DATE_TIME_FORMAT);
		return formatter.parse(text, Locale.getDefault());
	}
}
