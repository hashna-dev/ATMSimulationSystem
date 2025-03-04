package com.ty.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("Name", "KRISHNA");
		model.addAttribute("CurrentDate", new Date());

		return "about";

	}
	@GetMapping("/loop")
	public String iterateHandler(Model model) {
		List<String> names= new ArrayList<String>();
		names.add("Sree");
		names.add("Krishna");
		names.add("Manju");
		names.add("Geetha");
		names.add("Paru");
		

		model.addAttribute("names", names);
		return "loop";
		
	}
	@GetMapping("/condition")
	public String conditionalStatement( Model model) {
		 
		model.addAttribute("isActive", true); 
		
		model.addAttribute("gender", "m");
		
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(20);
		list.add(40);
		list.add(60);
		model.addAttribute("mylist", list);
		
		return "condition";
		
	}
	@GetMapping("/service")
	public String fragmentHandler(Model model) {
		model.addAttribute("title","thymeleaf");
		model.addAttribute("subtitle","Springboot");
		return "service";
		
		
	}
	

}
