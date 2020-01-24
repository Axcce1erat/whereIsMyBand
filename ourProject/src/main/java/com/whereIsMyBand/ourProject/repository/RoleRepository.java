package com.whereIsMyBand.ourProject.repository;

import com.whereIsMyBand.ourProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
