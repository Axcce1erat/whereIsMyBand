package com.whereIsMyBand.ourProject.repository;

import com.whereIsMyBand.ourProject.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long>{
}
