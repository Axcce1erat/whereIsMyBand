package com.whereIsMyBand.ourProject.controller;

import com.whereIsMyBand.ourProject.entity.user.User;
import com.whereIsMyBand.ourProject.repository.user.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

	@Controller
	public class UserController {

	    
		//get User repository by dependency injection
		@Autowired
		private UserRepository userRepository;
		
		@Autowired 
	    private BCryptPasswordEncoder passwordEncoder;
     
		
		//get all users 
		@GetMapping("/user")
	    public String getAll(Model model, @ModelAttribute User user) {
		model.addAttribute("users", userRepository.findAll());  
		
		        return "user";
		    }
		
		
		// find User
	    @GetMapping("/anlegen")
	    public String getUser(Model model, 
	                            @RequestParam(required = false) Long id) { 
	    	User user = new User();
	    	if (id != null) {
	            Optional<User> optionalUser = userRepository.findById(id);
	            if (optionalUser.isPresent()) {
	               user = optionalUser.get();	            	
	            }

	    	}
	    	model.addAttribute("user", user);
	    	
	        
	        return "anlegen";
	    }
	    
	
	    //create or update a user
	   	@PostMapping("/anlegen")
	    public String postUser(@ModelAttribute User user) {
 			   		
	   		final String encodedPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(encodedPassword);
	   		userRepository.save(user);
	   	
	        return "redirect:/user";
	    }
	    
	  
		//delete a user
	    @GetMapping("/user/delete")
	    public String deleteUser(@RequestParam Long id ) {
	      
	    	userRepository.deleteById(id);
	        return "redirect:/user";
	    }
				
}
	


