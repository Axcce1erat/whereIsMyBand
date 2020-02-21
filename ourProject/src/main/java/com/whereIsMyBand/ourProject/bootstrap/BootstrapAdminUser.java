package com.whereIsMyBand.ourProject.bootstrap;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.whereIsMyBand.ourProject.entity.user.User;
import com.whereIsMyBand.ourProject.repository.user.UserRepository;

//@Component
public class BootstrapAdminUser implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public BootstrapAdminUser (UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	
	@Override
	public void run(String... args) throws Exception {
	 Optional<User> optionalAdmin = userRepository.findByName("admin");
	 if (optionalAdmin.isEmpty()) {
		 System.out.println("****No admin user, system is creating one");
		 User admin = new User();
		 admin.setName("admin");
		 admin.setRole("ADMIN");
		 admin.setPassword(passwordEncoder.encode("music"));
		 userRepository.save(admin);
	  }
	}
	
}
