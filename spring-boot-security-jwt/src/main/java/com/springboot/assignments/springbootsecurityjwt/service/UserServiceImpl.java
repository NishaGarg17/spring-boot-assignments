package com.springboot.assignments.springbootsecurityjwt.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.assignments.springbootsecurityjwt.entity.Authority;
import com.springboot.assignments.springbootsecurityjwt.entity.User;
import com.springboot.assignments.springbootsecurityjwt.repository.RoleRepository;
import com.springboot.assignments.springbootsecurityjwt.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		HashSet<Authority> roleSet = new HashSet<Authority>();
		roleSet.add(roleRepository.findByName("ROLE_EMPLOYEE"));
		user.setAuthorities(roleSet);
		userRepository.save(user);
		return user;
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

}
