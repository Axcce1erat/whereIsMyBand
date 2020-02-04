package com.whereIsMyBand.ourProject.repository;

import com.whereIsMyBand.ourProject.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

@Repository
public interface BandRepository extends JpaRepository<Band, Long>{
}
