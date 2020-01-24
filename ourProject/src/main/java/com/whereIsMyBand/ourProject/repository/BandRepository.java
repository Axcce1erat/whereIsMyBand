package com.whereIsMyBand.ourProject.repository;

import com.whereIsMyBand.ourProject.entity.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

@Repository
public interface BandRepository extends JpaRepository<Band, Long>{
//@Query("select band_name, city, skill.level, style.style_name from band join skill on skill.id=band.skill_id join style on style.id=band.style_id;")
//List<Band> findById(Integer id);
}
