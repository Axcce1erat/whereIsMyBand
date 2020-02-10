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
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
	public String getAll (HttpServletRequest request, Model model, @ModelAttribute Role role, @ModelAttribute Style style, @ModelAttribute Skill skill) {

	
		Band band = new Band();
                band.setStyle(style);
                band.setRole(role);
                band.setSkill(skill);

		int page = 0;
		int size = 10;

		System.out.println("selectedSkill "+request.getParameter("selectedSkill"));

		if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
		}

		if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
			size = Integer.parseInt(request.getParameter("size"));
		}


		model.addAttribute("bands", bandRepository.findAll(PageRequest.of(page, size)));
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("allStyles", styleRepository.findAll());
		model.addAttribute("allSkills", skillRepository.findAll());

		return "bands";
	} 


	@PostMapping("/bands")
	public String searchBand(HttpServletRequest request, Model model, @ModelAttribute Role role, @ModelAttribute Style style, @ModelAttribute Skill skill) {

		Band band = new Band();
		band.setStyle(style);
		band.setRole(role);
		band.setSkill(skill);


		int page = 0;
                int size = 10;

                if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
                        page = Integer.parseInt(request.getParameter("page")) - 1;
                }

                if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
                        size = Integer.parseInt(request.getParameter("size"));
                }
		
		model.addAttribute("bands", bandRepository.findAll(Example.of(band),PageRequest.of(page, size)));
		model.addAttribute("selectedSkill", skill.getId());
		model.addAttribute("selectedStyle", style.getId());
		model.addAttribute("selectedRole", role.getId());
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("allStyles", styleRepository.findAll());
		model.addAttribute("allSkills", skillRepository.findAll());

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
