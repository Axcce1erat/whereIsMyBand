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
	public String getBand(Model model, @RequestParam(required = false) Long id) {

		Band band = new Band();
		if (id != null) {
			Optional<Band> optionalBand = bandRepository.findById(id);
			if (optionalBand.isPresent()) {
				band = optionalBand.get();
			}
		}

		//Hier beginnt der Versuch des calls der Roles
		model.addAttribute("band", band);
		model.addAttribute("allRoles", roleRepository.findAll());
		model.addAttribute("allStyles", styleRepository.findAll());
		model.addAttribute("allSkills", skillRepository.findAll());

		// call the method getRoles in Band

		List<Role> roles = new ArrayList<>();
		Method methodRole = getMethod(band, "getRoles",
				new Class[]{});
		if (methodRole != null) {
			try {
				roles = (List<Role>) methodRole.invoke(band);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		model.addAttribute("bandRoles", roles);


		//call the method getStyles in Band

		List<Style> styles = new ArrayList<>();
		Method methodStyle = getMethod(band, "getStyles",
				new Class[]{});
		if (methodStyle != null) {
			try {
				styles = (List<Style>) methodStyle.invoke(band);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		model.addAttribute("bandStyles", roles);


		//call the method getSkills in Band

		List<Skill> skills = new ArrayList<>();
		Method methodSkill = getMethod(band, "getSkills",
				new Class[]{});
		if (methodSkill != null) {
			try {
				skills = (List<Skill>) methodSkill.invoke(band);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		model.addAttribute("bandSkills", skills);


		return "band";
	}

	/*@PostMapping("/band")
	  public String postSchool(@ModelAttribute Band band) {

	  bandRepository.save(band);

	  return "redirect:/bands";
	  }  */




	@PostMapping("/band")
	public String postRegister(@RequestParam Long idBand, @RequestParam Long idRole) {

		Optional<Role> optionalRole = RoleRepository.findById(idRole);
		if (optionalRole.isPresent()) {
			Role role = optionalRole.get();

			Optional<Band> optionalBand = bandRepository.findById(idBand);
			if (optionalBand.isPresent()) {
				Band band = optionalBand.get();


				// call the method setBand in Wizard
				Method method = getMethod(wizard, "setSchool",
						new Class[]{School.class});
				if (method != null) {
					try {
						method.invoke(wizard, school);
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				wizardRepository.save(wizard);
			}
		}

		return "redirect:/school/register?idSchool=" + idSchool;
	}






	@GetMapping("/band/delete")
	public String deleteBand(@RequestParam Long id) {

		bandRepository.deleteById(id);

		return "redirect:/bands";
	}

	//Hier ist die getMethod

	public Method getMethod(Object obj, String methodName, Class[] args) {
		Method method;
		try {
			method = obj.getClass().getDeclaredMethod(methodName, args);
			return method;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

}

