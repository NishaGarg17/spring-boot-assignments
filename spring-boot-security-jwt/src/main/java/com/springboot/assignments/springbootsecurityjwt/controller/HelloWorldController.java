package com.springboot.assignments.springbootsecurityjwt.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/")
	public String welcome() {
		return "welcome to spring security world";
	}
	@GetMapping("/hello-world")
	public String printHelloWorld() {
		return "hello-world";
	}
}
