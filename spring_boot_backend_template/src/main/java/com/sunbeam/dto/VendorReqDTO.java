package com.sunbeam.dto;




import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VendorReqDTO 
{
	private String ownerName;
	
	
	private String bussinessName;
	
	
	private String email;
	
	
	private String password;
	
	
	private String mobileNo;
	
	
	private String address;
	
	
//	private float rating;
	
//	private byte[] image;
	
	
	private int cin;
	
	

}
