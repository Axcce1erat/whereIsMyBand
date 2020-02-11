package com.whereIsMyBand.ourProject.repository;

import com.whereIsMyBand.ourProject.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{
}
