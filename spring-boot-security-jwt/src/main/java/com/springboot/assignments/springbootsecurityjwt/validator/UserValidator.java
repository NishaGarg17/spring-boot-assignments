package com.springboot.assignments.springbootsecurityjwt.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if(user.getUserName() != null && !user.getUserName().isEmpty() && userService.findByUserName(user.getUserName()) != null) {
		  System.out.println("User Already Exists"); 
		  errors.rejectValue("userName","duplicate.user.userName"); 
		}
		
		// Check if Email Already in use
		if(user.getEmail() != null && !user.getEmail().isEmpty() && userService.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "duplicate.user.email");
		}
		
		
		if(null != user.getPassword() && !user.getPassword().isEmpty()) {
			// password and confirm password must be same
			if(!user.getPassword().equals(user.getPasswordConfirm())) {
				errors.rejectValue("passwordConfirm", "different.user.passwordConfirm");
			}
			
			// pattern to compile allowed length for password
//			String passwordPolicy = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]))";
//			Pattern passwordLengthPattern = Pattern.compile("(passwordPolicy.*{5,15})");
//			Matcher passwordLengthMatcher = passwordLengthPattern.matcher(user.getPassword());
			
			// check if password follows minimum and maximum allowed length
			// check that password must contain at least one digit, one special character,
			// at least one lower case alphabet, at lease one upper case alphabet
			// and must be of minimum 5 length and max 15
			
			Pattern passwordPolicyPattern = Pattern.compile("(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%])(?=.*[A-Z])");
			Matcher passwordPolicymatcher = passwordPolicyPattern.matcher(user.getPassword());
			if(!passwordPolicymatcher.matches()) {
				System.out.println("policy not followed" + user.getPassword());
				errors.rejectValue("password", "criteria.policy.password");
			}
			/*
			 * else if(!passwordLengthMatcher.matches()) {
			 * errors.rejectValue("password","size.policy.password"); }
			 */ 
		}
		
		
	}

}
