package com.whereIsMyBand.ourProject.service;

	import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.whereIsMyBand.ourProject.entity.user.AdminUserDetails;
import com.whereIsMyBand.ourProject.entity.user.User;
import com.whereIsMyBand.ourProject.repository.user.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	
	private final String adminPassword;
	
	
	@Autowired
	public UserDetailsServiceImpl (UserRepository userRepository, @Value( "${admin.password}") String adminPassword) {
		super();
		this.userRepository= userRepository;
		this.adminPassword = adminPassword;
	}
	
	@Override
	public UserDetails loadUserByUsername (String name) throws UsernameNotFoundException {
		
		if ("admin".equals(name)){
			
			return new AdminUserDetails("admin", adminPassword);
		}
				
		Optional<User> optionalUser = userRepository.findByName(name);
		if (!optionalUser.isPresent()) {
			throw new UsernameNotFoundException("User " + name + " not found");
		}
		return optionalUser.get();
	}
}
