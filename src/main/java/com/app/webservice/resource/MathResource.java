package com.app.webservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.webservice.controller.Utils;

@RestController
public class MathResource {	
	@RequestMapping(value="/makesum/{a}/{b}")
	public String makeSum(@PathVariable("a") String a, @PathVariable("b") String b) {
		return Utils.makeSum(a, b);
	}
	
	@RequestMapping(value="/makesub/{a}/{b}")
	public String makeSub(@PathVariable("a") String a, @PathVariable("b") String b) {
		return Utils.makeSub(a, b);
	}
	
	@RequestMapping(value="/makemul/{a}/{b}")
	public String makeMul(@PathVariable("a") String a, @PathVariable("b") String b) {
		return Utils.makeMul(a, b);
	}
	
	@RequestMapping(value="/makediv/{a}/{b}")
	public String makeDiv(@PathVariable("a") String a, @PathVariable("b") String b) {
		return Utils.makeDiv(a, b);
	}
}
