package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.Requirement;

public interface  RequirementDao extends JpaRepository<Requirement, Long> {

	List<Requirement> findAllByServiceRequestId(Long serviceRequestId);
}
