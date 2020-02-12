package com.whereIsMyBand.ourProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.whereIsMyBand.ourProject.entity.user.User;
import com.whereIsMyBand.ourProject.repository.user.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserDetailsServiceImpl (UserRepository userRepository) {
		super();
		this.userRepository= userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername (String name) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByName(name);
		if (!optionalUser.isPresent()) {
			throw new UsernameNotFoundException("User " + name + " not found");
		}
		
		return optionalUser.get();
	}
	
}
