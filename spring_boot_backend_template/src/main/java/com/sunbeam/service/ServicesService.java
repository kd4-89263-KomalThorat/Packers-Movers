package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ServiceReqDTO;
import com.sunbeam.dto.ServiceResDTO;

public interface ServicesService {

	ApiResponse addService(ServiceReqDTO serviceReqDTO);

	List<ServiceResDTO> getAllServices();

}
