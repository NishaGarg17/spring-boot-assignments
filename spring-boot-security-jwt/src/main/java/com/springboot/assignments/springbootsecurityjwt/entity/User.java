package com.springboot.assignments.springbootsecurityjwt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "The User Name must not be null")
	@Column(name="username",unique=true)
	@Size(min=1, message = "User Name is Required")
	//@Column(name="username")
	private String userName;
	
	@NotNull(message = "The Email must not be null")
	@Size(min=1, message = "Email is Required")
	@Column(unique=true)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotNull(message = "The password must not be null")
	@Size(min=5, message = "Password is Required and minimum length = 5")
	private String password;
	
	@Transient
	@Size(min=1, message = "Confirm Password is Required")
	private String passwordConfirm;
	
	private Boolean enabled;
	
	@ManyToMany
	private Set<Authority> authorities;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
