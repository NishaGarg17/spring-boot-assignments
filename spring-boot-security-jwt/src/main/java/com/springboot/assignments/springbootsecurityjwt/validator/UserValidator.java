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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName" , "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
		System.out.println("inside UserValidator");
		if(userService.findByUserName(user.getUserName()) != null) {
		  System.out.println("User Already Exists"); 
		  errors.rejectValue("userName","duplicate.user.userName"); 
		}
		
		// password and confirm password must be same
		if(!user.getPassword().equals(user.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", "different.user.passwordConfirm");
		}
		 
		//Check if Email Already in use
		if(userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "duplicate.user.email");
		}
	}

}
