package com.springboot.assignments.springbootsecurityjwt.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String welcome() {
		return "welcome to spring security world";
	}
	@GetMapping("/home-page")
	public String showHomePage() {
		return "home-page";
	}
	
	@GetMapping("/leaders")
	public String showLeadersForum() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showAdminForum() {
		return "systems";
	}
	
}
