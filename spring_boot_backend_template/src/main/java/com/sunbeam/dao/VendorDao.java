package com.sunbeam.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.Vendor;



public interface VendorDao extends JpaRepository<Vendor, Long>
{
	
	Optional<Vendor>  findByEmailAndPassword(String email, String password);
	
}
