package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.Services;

public interface ServicesDao extends JpaRepository<Services, Long> {
	 Optional<Services> findByServiceName(String serviceName);

}
