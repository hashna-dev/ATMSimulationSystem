package com.ty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.entity.LoginData;

import jakarta.validation.Valid;
@Controller
public class MyController {
	@GetMapping("/form")
	public String openForm(Model model) {
		model.addAttribute("loginData", new LoginData()); 
		
		return "form";
	}
	
	
	@PostMapping("/process")
	public String processForm( @Valid @ModelAttribute LoginData loginData,BindingResult result) {
		System.out.println(loginData);
		System.out.println(result);
		if(result.hasErrors()) {
			return "form";
		}
		return "success";
		
		
	}

}
