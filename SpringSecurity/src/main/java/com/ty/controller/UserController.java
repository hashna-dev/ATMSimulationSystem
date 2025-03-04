package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.model.Users;
import com.ty.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/users")
	public Users registerUser(@RequestBody Users users) {
		return service.register(users);
		
	}

}