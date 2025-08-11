package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.ServiceRequestDTO;
import com.sunbeam.dto.ServiceRequestResDTO;
import com.sunbeam.dto.ServiceRequestResUserDTO;
import com.sunbeam.pojos.RequestStatus;

public interface ServiceRequestService {

	ApiResponse createServiceRequest(ServiceRequestDTO requestDTO);
	
	List<ServiceRequestResDTO> getServiceRequestByVendor(Long vid);
	
	String updateRequestStatus(Long id, RequestStatus status);
	
	String cancelRequest(Long id);
	
	List<ServiceRequestResUserDTO> getServiceRequestByUserId(Long userId);

}
