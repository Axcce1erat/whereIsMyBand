package com.whereIsMyBand.ourProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

	@Configuration
	@EnableWebSecurity
	public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	    
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
			http     					
			.authorizeRequests()
		    	.antMatchers("/mailoutput").hasRole("ADMIN")
		    	.antMatchers("/band").hasRole("ADMIN")
		  //  	.and()
	      //  .formLogin()
	            .and()
	        .httpBasic();
			}   	
	  
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			
		auth.inMemoryAuthentication()
	    .withUser("Malte")    	
	    	.password(encoder.encode("music"))
	    	.roles("ADMIN")
	        .and()
	    .withUser("Denis")
	    	.password(encoder.encode("music"))
			.roles("ADMIN")
			.and()
	    .withUser("Axel")
	        .password(encoder.encode("music"))
	        .roles("ADMIN")
	        .and()
		.withUser("Bert")
        	.password(encoder.encode("music"))
        	.roles("ADMIN");
		}
	}


	


