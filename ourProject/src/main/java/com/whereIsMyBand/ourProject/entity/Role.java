package com.whereIsMyBand.ourProject.entity;

import javax.persistence.Entity;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.*;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String roleName;

	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List<Band> bands;

	public Role(){
	}

	public Role(String roleName){
	this.roleName=roleName;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id=id;
	}

	public String getRoleName(){
		return roleName;
	}

	public void setRoleName(String roleName){
		this.roleName=roleName;
	}

	public List<Band> getBands(){
        return bands;
    }

        public void setBands(List<Band> bands){
        this.bands=bands;
    }

}


