package com.example.SpringSecurity.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringSecurity.entities.User;
import com.example.SpringSecurity.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	Logger logger = LoggerFactory.getLogger(UserController.class);


	@GetMapping("/users")
	public String showUsers(ModelMap model) {


		logger.info("Getting all Users");
		Iterable<com.example.SpringSecurity.entities.User> users = userService.GetAllUsers();

		logger.info("Passing users to view");
		model.addAttribute("users", users);    

		return "users";
	}


}
