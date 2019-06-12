package com.app.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.webservice.model.Message;
import com.app.webservice.repository.MessageRepository;

@Controller
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	@RequestMapping(value="/store")
	public String store() {
		System.out.println("Empty message received, aborting operation.");
		return "redirect:/empty";
	}

	@RequestMapping(value="/store/{message}")
	public String store(@PathVariable("message") String message) {
		System.out.println("Saving new message received...");

		Message messageObj = new Message();
		messageObj.setTimestamp(Utils.getTimestampStr());
		messageObj.setMessage(message);
		messageRepository.save(messageObj);
		
		System.out.println("Saved!");
		
		return "redirect:/success";
	}
}
