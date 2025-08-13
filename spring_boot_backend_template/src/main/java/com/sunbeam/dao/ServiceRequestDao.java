package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.ServiceRequest;

public interface ServiceRequestDao extends JpaRepository<ServiceRequest, Long>   {

	List<ServiceRequest> findAllByVendorId(Long vid);
	
	List<ServiceRequest> findAllByUserId(Long userId);

}
