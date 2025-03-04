package com.ty;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		return "This is the home page"+request.getSession().getId();
	}

}
