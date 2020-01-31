package com.whereIsMyBand.ourProject.controller;

import com.whereIsMyBand.ourProject.entity.Mail;
import com.whereIsMyBand.ourProject.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

	@Controller
	public class MailController {

	    
		// TODO : get mail repository by dependency injection
		@Autowired
		private MailRepository mailRepository;
	    
		// TODO : get all mails
		@GetMapping("/mails")
	    public String getAll(Model model) {

		  model.addAttribute("mails", mailRepository.findAll());
		        return "mails";
		    }
		
		@PostMapping("/mails")
	    public String postMail(Model model,@ModelAttribute Mail mail) {
		
			mailRepository.save(mail);
			model.addAttribute("mails", mailRepository.findAll());    
						
	        return "mails";
	    }
		
	  /*  @GetMapping("/bands")
	    public String getAll(Model model) {

	       model.addAttribute("bands", bandRepository.findAll());

	        return "bands";
	    }*/
		
		
		
		@GetMapping ("/")
		public String getMail(Model model) {
			return "index";
		}
		

				
	/*	@PostMapping("/")
	    public String postMail(Model model,@ModelAttribute Mail mail) {

	            mailRepository.save(mail);

	        return "mails";
	    }*/
	    
	}


