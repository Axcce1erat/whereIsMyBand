package com.whereIsMyBand.ourProject.entity;

import javax.persistence.Entity;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.*;

@Entity
public class Style {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String styleName;

	@OneToMany(mappedBy = "style", cascade = CascadeType.ALL)
	private List<Band> bands;


	public Style(){
	}

	public Style(String styleName){
		this.styleName=styleName;
	}


	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id=id;
	}

	public String getStyleName(){
		return styleName;
	}

	public void setStyleName(String styleName){
		this.styleName=styleName;
	}

	public List<Band> getBands(){
		return bands;
	}

	public void setBands(List<Band> bands){
		this.bands=bands;
	}

}
