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
	    
		
		@GetMapping("/mails")
	    public String getAll(Model model) {
		
		        return "mails";
		    }
		
		@PostMapping("/mails")
	    public String postMail(Model model, @ModelAttribute Mail mail) {
			mailRepository.save(mail);
						
	        return "mails";
	    }
		
		//TODO : get all mails
		@GetMapping("/mailoutput")
	    public String postMailoutput(Model model,@ModelAttribute Mail mail) {
			model.addAttribute("mailoutput", mailRepository.findAll());    
					
	    return "mailoutput";
	    }
		
		//delete mails
	    @GetMapping("/mailoutput/delete")
	    public String deleteMails(@RequestParam Long id ) {
	      
	    	mailRepository.deleteById(id);
	        return "redirect:/mailoutput";
	    }
		
		
		@GetMapping ("/")
		public String getMail(Model model) {
			return "index";
		}
	    
	}


