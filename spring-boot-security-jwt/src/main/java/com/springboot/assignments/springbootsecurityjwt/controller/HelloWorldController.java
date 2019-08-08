package com.springboot.assignments.springbootsecurityjwt.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/hello-world")
	public String printHelloWorld() {
		return "hello-world";
	}
}
