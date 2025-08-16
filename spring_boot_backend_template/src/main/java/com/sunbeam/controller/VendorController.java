package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.dto.*;
import com.sunbeam.service.VendorService;

@RestController
@RequestMapping("/Vendor")
//@CrossOrigin(origins = "*")

public class VendorController 
{
	@Autowired
	private VendorService vendorService;
	
	public VendorController()
	{
		System.out.println("Inside VendorController");
		
	}

	@PostMapping
	public ResponseEntity<?> signUp(@RequestBody VendorReqDTO vendorDto)
	{
		System.out.println("In Signup :"+vendorDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.signIn(vendorDto));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllVendors() {
		return  ResponseEntity.ok(vendorService.getAllVendors());
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody AuthRequest dto)
	{
		System.out.println("in user sign in "+dto);
		try {
			return ResponseEntity.ok(vendorService.signIn(dto));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new com.sunbeam.dto.ApiResponse(e.getMessage()));
		}
	}
	
}