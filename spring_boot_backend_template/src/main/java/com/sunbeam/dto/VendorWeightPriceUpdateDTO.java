package com.sunbeam.dto;





import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class VendorWeightPriceUpdateDTO 
{
	//private Long id;

    private Double minWeight;

    private Double maxWeight;

    private Double pricePerKm;
    
    public VendorWeightPriceUpdateDTO(Long id ,Double minWeight, Double maxWeight, Double pricePerKm) {
        //this.id = id;
    	this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.pricePerKm = pricePerKm;
    }
}
