package com.sunbeam.service;


import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.VendorServiceDTO;
import com.sunbeam.dto.VendorServiceResDTO;


public interface VendorServicesService 
{
	ApiResponse addVendorService(VendorServiceDTO vendorServiceDto);
	
	List<VendorServiceDTO> getAllServices();
	
	List<VendorServiceResDTO> getAllServicesByVendorID(Long id);
	
	ApiResponse deleteVendorService(VendorServiceResDTO dto);
	ApiResponse updatePrice(VendorServiceResDTO dto);

}