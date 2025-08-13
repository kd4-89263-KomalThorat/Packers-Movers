package com.sunbeam.dto;




import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class VendorServiceResDTO 
{
	
	private Long vendorid;
	
	
	private String servicesName;


	private Long price;

}