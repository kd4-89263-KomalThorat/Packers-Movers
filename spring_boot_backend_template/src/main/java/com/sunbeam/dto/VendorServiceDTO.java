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

public class VendorServiceDTO 
{
	
	private Long vendorid;
	
	
	private Long servicesid;


	private Long price;

}
