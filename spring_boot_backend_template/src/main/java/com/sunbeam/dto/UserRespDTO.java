package com.sunbeam.dto;

import com.sunbeam.pojos.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRespDTO extends BaseDTO{
 
	private String fullName;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private String city;
	
	private UserRole role;
	
	private String token;
	
	boolean deleteStatus;
}
