package com.springboot.assignments.springbootsecurityjwt.service;

import com.springboot.assignments.springbootsecurityjwt.entity.User;

public interface UserService {
	public User saveUser(User user);
	public User findByUserName(String username);
	public User findByEmail(String email);
}
