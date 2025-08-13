package com.sunbeam.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ServiceResDTO 
{
	private Long id;
	private String serviceName;
	
	private String description;
}