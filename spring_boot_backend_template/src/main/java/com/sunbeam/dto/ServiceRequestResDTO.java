package com.sunbeam.dto;


import lombok.*;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojos.PaymentStatus;
import com.sunbeam.pojos.RequestStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestResDTO {
	private Long serviceRequestId;
    private String userName;     
    private String email; 
    private Long vendorId;                         
    private String shifting;   
    private double shipmentWeight; 
    private String pickupLocation;                 
    private String dropoffLocation;                
    private Date preferredDate;                    
    private RequestStatus requestStatus;           
    private PaymentStatus paymentStatus;           
    private Boolean isDeleted;                     
    private List<String> serviceNames;             
}