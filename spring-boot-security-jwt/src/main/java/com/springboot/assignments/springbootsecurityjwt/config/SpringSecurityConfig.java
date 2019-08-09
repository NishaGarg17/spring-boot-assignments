
package com.springboot.assignments.springbootsecurityjwt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		// auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		/*
		 * httpSecurity.authorizeRequests().antMatchers("/console/**").permitAll();
		 * 
		 * httpSecurity.csrf().disable();
		 * httpSecurity.headers().frameOptions().disable();
		 */
		httpSecurity.authorizeRequests()
        .antMatchers("/h2-console/**").permitAll()//allow h2 console access
        .anyRequest().authenticated()//all other urls can be access by any authenticated role
        .and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
        .and().headers().frameOptions().sameOrigin();

	}

}