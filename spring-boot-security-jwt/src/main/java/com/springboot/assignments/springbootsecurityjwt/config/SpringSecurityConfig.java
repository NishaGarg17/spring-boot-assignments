
package com.springboot.assignments.springbootsecurityjwt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/employees").hasAnyRole("ADMIN","MANAGER","EMPLOYEE")
		.antMatchers("/leaders").hasRole("MANAGER")
		.antMatchers("/systems").hasRole("ADMIN")
		.and().formLogin().loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/employees").permitAll()
		.and().logout().logoutSuccessUrl("/login").permitAll();
	}
	
	 @Bean
	    public BCryptPasswordEncoder bcryptPasswordEncoder(){
	        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bcryptPasswordEncoder;
	    }
	
	
}