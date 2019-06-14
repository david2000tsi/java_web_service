package com.app.webservice.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Utils {
	
	public static boolean isValidNumber(String number) {
		try {
			Integer.parseInt(number);
		}catch (Exception e) {
			return false;
		}

		return true;
	}
	
	public static String getTimestampStr() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timestamp.getTime());
	}

	@RequestMapping(value="/gettimestamp")
	public String getTimestamp() {
		return getTimestampStr();
	}
	
	@RequestMapping(value="/makesum/{a}/{b}")
	public String makeSum(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
	}
	
	@RequestMapping(value="/makesub/{a}/{b}")
	public String makeSub(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
	}
	
	@RequestMapping(value="/makemul/{a}/{b}")
	public String makeMul(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
	}
	
	@RequestMapping(value="/makediv/{a}/{b}")
	public String makeDiv(@PathVariable("a") String a, @PathVariable("b") String b) {
		if(!isValidNumber(a) || !isValidNumber(b)) {
			return "Invalid parameters!";
		}
		if(Integer.parseInt(b) == 0) {
			return "Invalid division by zero!";
		}
		return Integer.toString(Integer.parseInt(a) / Integer.parseInt(b));
	}
}
