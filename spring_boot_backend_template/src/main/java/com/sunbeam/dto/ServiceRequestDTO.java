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
public class ServiceRequestDTO {
    private Long userId;                           
    private Long vendorId;                         
    private Long shiftingId;                       
    private String pickupLocation;                 
    private String dropoffLocation;                
    private Date preferredDate;                    
    private List<Long> requirementIds;   // Updated field name
    private RequestStatus requestStatus;           
    private PaymentStatus paymentStatus;           
    private Boolean isDeleted;                     
    private double shipmentWeight;                 
}
