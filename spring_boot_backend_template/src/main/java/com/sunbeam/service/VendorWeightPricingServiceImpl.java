package com.sunbeam.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sunbeam.dao.ShiftingTypeDao;
import com.sunbeam.dao.VendorDao;
import com.sunbeam.dao.VendorWeightPricingDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.VendorWeightPriceUpdateDTO;
import com.sunbeam.dto.VendorWeightPricingDTO;
import com.sunbeam.pojos.ShiftingType;
import com.sunbeam.pojos.Vendor;
import com.sunbeam.pojos.VendorWeightPricing;

public class VendorWeightPricingServiceImpl implements VendorWeightPricingService{
	
	@Autowired
	private VendorWeightPricingDao vendorWeightPricingDao;
	
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private ShiftingTypeDao shiftingTypeDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse savePricing(VendorWeightPricingDTO pricing) {
		 Vendor vendor = venderDao.findById(pricing.getVendor())
	    	        .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + pricing.getVendor()));
	    	    
	    	    ShiftingType shiftingType = shiftingTypeDao.findById(pricing.getShiftingType())
	    	        .orElseThrow(() -> new RuntimeException("ShiftingType not found with ID: " + pricing.getShiftingType()));
	    	    
	    	    VendorWeightPricing vendorWeightPricing = new VendorWeightPricing();
	    	    
	    	    vendorWeightPricing.setVendor(vendor);
	    	    vendorWeightPricing.setShiftingType(shiftingType);
	    	    vendorWeightPricing.setMinWeight(pricing.getMinWeight());
	    	    vendorWeightPricing.setMaxWeight(pricing.getMaxWeight());
	    	    vendorWeightPricing.setPricePerKm(pricing.getPricePerKm());
	    	    
	    	    vendorWeightPricing.setCreatedOn(LocalDate.now());
	    	    vendorWeightPricing.setUpdatedOn(LocalDateTime.now());
	    	    
	    	    vendorWeightPricingDao.save(vendorWeightPricing);

	    	    return new ApiResponse("Added new VendorWeightPricing for Vendor ");
	}

	@Override
	public List<VendorWeightPricing> getAllPricing() {
		 return vendorWeightPricingDao.findAll();

	}

	@Override
	public Optional<VendorWeightPricing> getPricingById(Long id) {
		 return vendorWeightPricingDao.findById(id);	}

	@Override
	public void deletePricing(Long id) {
		vendorWeightPricingDao.deleteById(id);
		
	}

	@Override
	public List<VendorWeightPricingDTO> getVendorPrice(Long vendorId) {
		return vendorWeightPricingDao.findByVendorId(vendorId);
	}

	@Override
	public VendorWeightPriceUpdateDTO updateVendorWeightandPrice(Long vendorPriceWeightId,
			VendorWeightPriceUpdateDTO vendorWeightPrice) {
		VendorWeightPricing vendorEnity = vendorWeightPricingDao.findById(vendorPriceWeightId).orElseThrow(()->new RuntimeException("Pricing not found for ID :"+vendorWeightPriceId));
		
		 vendorEnity.setPricePerKm(vendorWeightPrice.getPricePerKm());
		 vendorEnity.setMaxWeight(vendorWeightPrice.getMaxWeight());
		 vendorEnity.setMinWeight(vendorWeightPrice.getMinWeight());
		 
		 vendorEnity = vendorWeightPricingDao.save(vendorEnity);
		 
		 return new VendorWeightPriceUpdateDTO(
				 vendorEnity.getId(),
				 vendorEnity.getMinWeight(),
				 vendorEnity.getMaxWeight(),
				 vendorEnity.getPricePerKm()
			    );
	}

}
