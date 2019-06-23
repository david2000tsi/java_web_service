package com.app.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.webservice.model.Message;
import com.app.webservice.repository.MessageRepository;

@Controller
public class MessageController {

	@Autowired
	private MessageRepository messageRepository;
	
	// Handle /save request with no parameters.
	@RequestMapping(value="/message/save")
	public String save() {
		System.out.println("Empty message received, aborting operation.");
		return "redirect:/message/empty";
	}

	// Handle valid /save request.
	@RequestMapping(value="/message/save/{message}")
	public String save(@PathVariable("message") String message) {
		System.out.println("Saving new message received.");

		Message messageObj = new Message();
		messageObj.setTimestamp(Utils.getTimestamp());
		messageObj.setMessage(message);
		messageRepository.save(messageObj);
		
		System.out.println("Saved!");
		
		return "redirect:/message/saved";
	}
	
	// Handle get request.
	@RequestMapping(value="/message/get")
	@ResponseBody
	public String get() {
		Iterable<Message> messages = messageRepository.findAll();
		String messageStr = "";
		
		for(Message m : messages) {
			messageStr = messageStr + m.getId() + " - " + m.getTimestamp() + " - " + m.getMessage() + "</br>";
		}
		
		if(messageStr.length() == 0) {
			messageStr = "There is no messages saved!";
		}

		return messageStr;
	}
	
	// Handle /update request with no parameters.
	@RequestMapping(value= {"/message/update", "/message/update/{id}"})
	public String update() {
		System.out.println("Empty parameters received, aborting operation.");
		return "redirect:/message/empty";
	}
	
	// Handle valid /update request.
	@RequestMapping(value="/message/update/{id}/{newMessageStr}")
	public String delete(@PathVariable("id") long id, @PathVariable("newMessageStr") String newMessageStr) {
		Message message = messageRepository.findById(id).orElse(new Message());
		
		// Check if message is valid (if it was recovered from database).
		if(message.getId() > 0) {
			System.out.println("Updating new message received.");

			message.setMessage(newMessageStr);
			messageRepository.save(message);
			
			System.out.println("Updated!");
			
			return "redirect:/message/updated";
		}
		
		return "redirect:/message/notexists";
	}
	
	// Handle /delete request with no parameters.
	@RequestMapping(value="/message/delete")
	public String delete() {
		System.out.println("Empty parameters received, aborting operation.");
		return "redirect:/message/empty";
	}
	
	// Handle valid /delete request.
	@RequestMapping(value="/message/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		Message message = messageRepository.findById(id).orElse(new Message());
		
		// Check if message is valid (if it was recovered from database).
		if(message.getId() > 0) {
			System.out.println("Deleting message received.");

			messageRepository.delete(message);
			
			System.out.println("Deleted!");

			return "redirect:/message/deleted";
		}
		
		return "redirect:/message/notexists";
	}
	
	// Save operation response.
	@RequestMapping(value="/message/saved")
	@ResponseBody
	public String saved() {
		return "Message saved successfully!";
	}
	
	// Update operation response.
	@RequestMapping(value="/message/updated")
	@ResponseBody
	public String updated() {
		return "Message updated successfully!";
	}
	
	// Delete operation response.
	@RequestMapping(value="/message/deleted")
	@ResponseBody
	public String removed() {
		return "Message deleted successfully!";
	}
	
	// Empty message operation response.
	@RequestMapping(value="/message/empty")
	@ResponseBody
	public String empty() {
		return "Empty parameters received, aborting operation.";
	}
	
	// Not exists message operation response.
	@RequestMapping(value="/message/notexists")
	@ResponseBody
	public String notFound() {
		return "The requested message not exists";
	}
}
