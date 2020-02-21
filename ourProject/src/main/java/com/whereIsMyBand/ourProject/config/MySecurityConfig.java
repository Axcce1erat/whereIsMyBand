package com.whereIsMyBand.ourProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

	@Configuration
	@EnableWebSecurity
	public class MySecurityConfig extends WebSecurityConfigurerAdapter {

		private final UserDetailsService userDetailsService;

		private final PasswordEncoder passwordEncoder;


		@Autowired
		public MySecurityConfig (UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
			super();
			this.userDetailsService = userDetailsService;
			this.passwordEncoder = passwordEncoder;
		}


		@Override
	    protected void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests()
		    	.antMatchers("/", "/bands", "/mails", "/pictures/**", "/css/**", "/fragments/**").permitAll()
		    	.antMatchers("/bands").hasAnyRole("ADMIN", "USER")
		    	.antMatchers("/user","/mailoutput","/admin","/band","/anlegen").hasRole("ADMIN")
		    	.anyRequest().authenticated()
		    	.and()
		    	.formLogin()
	            .and()
	        .httpBasic();
			}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}


//	public static void main (String [] args) {
//	System.out.println(new BCryptPasswordEncoder().encode("music"));
//
//	}
//
}
