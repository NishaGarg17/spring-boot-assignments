package com.springboot.assignments.springbootsecurityjwt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.assignments.springbootsecurityjwt.entity.User;
import com.springboot.assignments.springbootsecurityjwt.service.UserService;

@Controller
public class DemoController {
	
	private UserService userService;
	
	@Autowired
	public DemoController(UserService userService) {
		this.userService = userService;
	}
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
	
	@PostMapping("/save-welcome-user")
	public String saveAndAutoLoginAsEmployee(@ModelAttribute User user) {
		userService.saveUser(user);
		return "login";
	}
	
}
