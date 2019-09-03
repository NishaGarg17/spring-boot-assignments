package com.springboot.assignments.springbootsecurityjwt.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.assignments.springbootsecurityjwt.entity.User;

@Controller
public class DemoController {
	@GetMapping("/")
	public String welcome() {
		return "home";
	}
	@GetMapping("/employees")
	public String showHomePage() {
		return "employees";
	}
	
	@GetMapping("/leaders")
	public String showLeadersForum() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showAdminForum() {
		return "systems";
	}
	
	@GetMapping("/sign-up")
	public String showSignUpPage(Model model) {
		model.addAttribute("user", new User());
		return "sign-up";
	}
	
}
