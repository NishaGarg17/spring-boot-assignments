package com.springboot.assignments.springbootsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.assignments.springbootsecurityjwt.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserName(String username);
}
