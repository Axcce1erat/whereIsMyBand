package com.whereIsMyBand.ourProject.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whereIsMyBand.ourProject.entity.user.User;


public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByName(String name);

	void deleteByName(String name);
		
}
