package com.sunbeam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserReqDTO {
	
	private String fullName;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private String address;
	
	private String city;
	

}
