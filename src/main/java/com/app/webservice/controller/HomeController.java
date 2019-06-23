package com.app.webservice.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController implements ErrorController {
	
	private static final String PATH = "/error";
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		return new ModelAndView("home.html");
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
