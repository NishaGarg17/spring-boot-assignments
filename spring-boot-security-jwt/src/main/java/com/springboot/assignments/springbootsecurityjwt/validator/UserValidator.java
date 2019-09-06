package com.springboot.assignments.springbootsecurityjwt.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springboot.assignments.springbootsecurityjwt.entity.User;
import com.springboot.assignments.springbootsecurityjwt.service.UserService;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName" , "Not Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Not Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Not Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "Not Empty");
		System.out.println("inside UserValidator");
		if(userService.findByUserName(user.getUserName()) != null) {
		  System.out.println("User Already Exists"); 
		  errors.rejectValue("userName","User Already exists"); 
		  
		}
		 
		
	}

}
