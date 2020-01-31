package com.whereIsMyBand.ourProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.whereIsMyBand.ourProject.entity.Mail;
 


@Repository
public interface MailRepository extends JpaRepository<Mail, Long> {
	
	}
	
	
	

