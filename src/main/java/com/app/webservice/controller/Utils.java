package com.app.webservice.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Utils {
	
	public static boolean isValidNumber(String number) {
		try {
			Integer.parseInt(number);
		}catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static String getTimestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timestamp.getTime());
	}
	
	public static String makeSum(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
	}
	
	public static String makeSub(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
	}
	
	public static String makeMul(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
	}
	
	public static String makeDiv(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		if(Integer.parseInt(b) == 0) {
			return "Invalid division by zero!";
		}
		return Integer.toString(Integer.parseInt(a) / Integer.parseInt(b));
	}
}
