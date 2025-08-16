package com.sunbeam.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.VendorServiceDTO;
import com.sunbeam.dto.VendorServiceResDTO;
import com.sunbeam.service.VendorServicesService;



@RestController
@RequestMapping("/VendorServices")
//@CrossOrigin(origins = "*")
public class VendorServicesController 
{
	@Autowired
	private VendorServicesService vendorServicesService;
	
	public VendorServicesController()
	{
		System.out.println("Inside VendorServiceController");
		
	}
	
	@PostMapping
	public ResponseEntity<?> addVServices(@RequestBody VendorServiceDTO vendorDto)
	{
		System.out.println("In  :"+vendorDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(vendorServicesService.addVendorService(vendorDto));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllServices() {
		return  ResponseEntity.ok(vendorServicesService.getAllServices());
	}
	
	@GetMapping("/getByid/{id}")
	public ResponseEntity<?> getAllServicesByVednorID(@PathVariable Long id ) 
	{
		return  ResponseEntity.ok(vendorServicesService.getAllServicesByVendorID(id));
	}
	
	@PutMapping("/update-price")
    public ResponseEntity<ApiResponse> updatePrice(@RequestBody VendorServiceResDTO dto) {
        ApiResponse response = vendorServicesService.updatePrice(dto);
        return ResponseEntity.ok(response);
    }
 
 @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteVendorService(@RequestBody VendorServiceResDTO dto) {
        ApiResponse response = vendorServicesService.deleteVendorService(dto);
        return ResponseEntity.ok(response);
    }

}