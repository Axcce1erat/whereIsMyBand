package com.whereIsMyBand.ourProject.entity;

import java.util.*;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Band {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bandName;
	private String city;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
        @JoinColumn(name = "role_id", nullable = false)
        private Role role;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
        @JoinColumn(name = "style_id", nullable = false)
        private Style style;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
        @JoinColumn(name = "skill_id", nullable = false)
        private Skill skill;


	public Band() {
	}

	public Band (String bandName, String city, Style style, Skill skill, Role role){
        this.bandName=bandName;
        this.city=city;
        this.style=style;
        this.skill=skill;
	this.role=role;
	} 


	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id=id;
	}

	public String getBandName(){
		return bandName;
	}

	public void setBandName(String bandName){
		this.bandName=bandName;
	}

	public String getCity(){
		return city;
	}

	public void setCity(String city){
		this.city=city;
	}

	public Style getStyle(){
		return style;
	}

	public void setStyle(Style style){
		this.style=style;
	}

	public Skill getSkill(){
		return skill;
	}

	public void setSkill(Skill skill){
		this.skill=skill;
	} 

	 public Role getRole(){
                return role;
        }

        public void setRole(Role role){
                this.role=role;
        }
}
