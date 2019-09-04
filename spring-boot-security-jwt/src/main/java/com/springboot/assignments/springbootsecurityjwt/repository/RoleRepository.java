package com.springboot.assignments.springbootsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.assignments.springbootsecurityjwt.entity.Authority;

public interface RoleRepository extends JpaRepository<Authority, Long> {
	public Authority findByName(String roleName);
}
