package com.app.webservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.webservice.model.User;
import com.app.webservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	// Handle get request.
	@RequestMapping(value="/user/get/json")
	@ResponseBody
	public String getAllUsersJson() {
		String usersJson = "";

		try {
			List<User> usersList = (List<User>) userRepository.findAll();
			Map<String, User> usersMap = new HashMap<>();
			if(usersList.size() > 0) {
				for(int i = 0; i < usersList.size(); i++) {
					String iStr = String.format("%03d", i + 1);
					usersMap.put(iStr, usersList.get(i));
				}

				ObjectMapper objMap = new ObjectMapper();
				objMap.writerWithDefaultPrettyPrinter();
				usersJson = objMap.writeValueAsString(usersMap);
			}
		} catch(Exception e) {
			// Handle exception...
			usersJson = "Exception: [" + e.getMessage() + "]";
		}

		return usersJson;
	}
}
