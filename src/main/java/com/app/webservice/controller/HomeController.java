package com.app.webservice.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController implements ErrorController {
	
	private static final String PATH = "/error";
	
	@RequestMapping(value="/")
	public String home() {
		return "Hello world!!!";
	}

	@RequestMapping(value="/success")
	public String success() {
		return "Message saved successfully!";
	}
	
	@RequestMapping(value="/empty")
	public String empty() {
		return "Empty message received.";
	}
	
	@RequestMapping(value=PATH)
	public String error() {
		return "We got an error!";
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}
}
