package com.sunbeam.service;



import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.VendorReqDTO;
import com.sunbeam.dto.VendorResDTO;


public interface VendorService 
{
	ApiResponse signIn(VendorReqDTO dto);
	
	List<VendorResDTO> getAllVendors();
	
	VendorResDTO signIn(AuthRequest dto);

}
