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

		return "bands";
	}

	@GetMapping("/band")
	public String getBand(Model model) {

		Band band = new Band();

		model.addAttribute("band", band);
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("allStyles", styleRepository.findAll());
		model.addAttribute("allSkills", skillRepository.findAll());


		return "band";
	}

	@PostMapping("/band")
	public String postBand(Model model, @ModelAttribute Band band, @ModelAttribute Role role, @ModelAttribute Style style, @ModelAttribute Skill skill) {

		bandRepository.save(band);
		roleRepository.save(role);
		styleRepository.save(style);
		skillRepository.save(skill);	

		return "redirect:/bands";
	}

	@GetMapping("/band/delete")
	public String deleteBand(@RequestParam Long id) {

		bandRepository.deleteById(id);

		return "redirect:/bands";
	}

}
