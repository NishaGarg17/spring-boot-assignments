package com.springboot.assignments.springbootsecurityjwt.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.assignments.springbootsecurityjwt.entity.User;
import com.springboot.assignments.springbootsecurityjwt.service.UserService;
import com.springboot.assignments.springbootsecurityjwt.validator.UserValidator;

@Controller
public class DemoController {
	
	private UserService userService;
	private UserValidator userValidator;
	
	@Autowired
	public DemoController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
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
	//https://spring.io/guides/gs/validating-form-input/
	
	@PostMapping("/save-welcome-user")
	public String saveAndAutoLoginAsEmployee(@Valid @ModelAttribute User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("**********************" + bindingResult.toString());
			return "sign-up";
		}
		userService.saveUser(user);
		return "home";
	}
	
}
