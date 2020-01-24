package com.whereIsMyBand.ourProject.entity;

import javax.persistence.Entity;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.*;


@Entity
public class Skill {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String level;

   @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<Band> bands;


    public Skill(){
    }

        public Skill(String level){
        this.level=level;
    }



    public Long getId(){
    	return id;
    }

    public void setId(Long id){
    	this.id=id;
    }

    public String getLevel(){
    	return level;
    }

    public void setLevel(String level){
    	this.level=level;
    }

    public List<Band> getBands(){
    	return bands;
    }

    public void setBands(List<Band> bands){
    	this.bands=bands;
    }
}
