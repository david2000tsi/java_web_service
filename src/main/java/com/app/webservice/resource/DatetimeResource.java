package com.app.webservice.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.webservice.controller.Utils;

@RestController
public class DatetimeResource {
	@RequestMapping(value="/gettimestamp")
	public String getTimestamp() {
		return Utils.getTimestamp();
	}
}
