package com.sunbeam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.ServicesDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ServiceReqDTO;
import com.sunbeam.dto.ServiceResDTO;
import com.sunbeam.pojos.Services;
import com.sunbeam.pojos.User;
import com.sunbeam.pojos.UserRole;
import com.sunbeam.pojos.Vendor;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	ServicesDao servicesDao;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public ApiResponse addService(ServiceReqDTO serviceReqDTO) 
	{
		Services serviceEntity = modelMapper.map(serviceReqDTO, Services.class);
		Services vendorPersistency = servicesDao.save(serviceEntity);
		
		return new ApiResponse("Added new Vendor with vendor Id :"+vendorPersistency.getId());
	}


	@Override
	public List<ServiceResDTO> getAllServices() {
		return servicesDao.findAll().stream().map(serv->(modelMapper.map(serv, ServiceResDTO.class))).collect(Collectors.toList());	}


	
}
