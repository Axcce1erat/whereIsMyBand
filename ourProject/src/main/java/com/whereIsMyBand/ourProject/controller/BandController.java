package com.whereIsMyBand.ourProject.controller;

import com.whereIsMyBand.ourProject.entity.Band;
import com.whereIsMyBand.ourProject.entity.Style;
import com.whereIsMyBand.ourProject.entity.Skill;
import com.whereIsMyBand.ourProject.entity.Role;
import com.whereIsMyBand.ourProject.repository.BandRepository;
import com.whereIsMyBand.ourProject.repository.SkillRepository;
import com.whereIsMyBand.ourProject.repository.StyleRepository;
import com.whereIsMyBand.ourProject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;
import org.springframework.data.domain.Example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BandController {

	@Autowired
	private BandRepository bandRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private StyleRepository styleRepository;

	@Autowired
	private RoleRepository roleRepository;

	@GetMapping("/bands")
	public String getAll(Model model) {

		model.addAttribute("bands", bandRepository.findAll());
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("allStyles", styleRepository.findAll());
		model.addAttribute("allSkills", skillRepository.findAll());

		return "bands";
	}


	@PostMapping("/bands")
	public String searchBand(Model model, @ModelAttribute Role role, @ModelAttribute Style style, @ModelAttribute Skill skill) {
	
	 	Band band = new Band();
		band.setRole(role);
		band.setStyle(style);
		band.setSkill(skill);

		model.addAttribute("bands", bandRepository.findAll(Example.of(band)));

		model.addAttribute("allRoles", roleRepository.findAll());
                model.addAttribute("allStyles", styleRepository.findAll());
                model.addAttribute("allSkills", skillRepository.findAll());

                return "bands";

	}

	@GetMapping("/band")
	public String getBand(Model model, 
				@RequestParam(required = false) Long id) {

		Band band = new Band();

		 if (id != null) {
            Optional<Band> optionalBand = bandRepository.findById(id);
            if (optionalBand.isPresent()) {
                band = optionalBand.get();

            }
                }

		//model.addAttribute("bandrole", band.getRole().getId());	
		model.addAttribute("bands", bandRepository.findAll());
		model.addAttribute("band", band);
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("allStyles", styleRepository.findAll());
		model.addAttribute("allSkills", skillRepository.findAll());


		return "band";
	}	

	@PostMapping("/band")
        public String postBand(Model model, @ModelAttribute Band band, @RequestParam Long roleid, @RequestParam Long styleid, @RequestParam Long skillid) {

                band.setStyle(styleRepository.findById(styleid).get());
                band.setSkill(skillRepository.findById(skillid).get());
                band.setRole(roleRepository.findById(roleid).get());
                bandRepository.save(band);

                return "redirect:/band";
        }


	@GetMapping("/band/delete")
	public String deleteBand(@RequestParam Long id) {

		bandRepository.deleteById(id);

		return "redirect:/band";
	}

}
