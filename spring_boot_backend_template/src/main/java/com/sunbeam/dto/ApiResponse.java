package com.sunbeam.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
	private String message;
	private LocalDateTime timeStamp;
	private boolean status;
	
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
	
	public ApiResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
        this.timeStamp = LocalDateTime.now();
    }

}
