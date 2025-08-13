package com.sunbeam.service;



import java.util.List;
import java.util.Optional;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.VendorWeightPriceUpdateDTO;
import com.sunbeam.dto.VendorWeightPricingDTO;
import com.sunbeam.pojos.VendorWeightPricing;

public interface VendorWeightPricingService {

	ApiResponse savePricing(VendorWeightPricingDTO pricing);

	List<VendorWeightPricing> getAllPricing();

	Optional<VendorWeightPricing> getPricingById(Long id);

	void deletePricing(Long id);

	List<VendorWeightPricingDTO> getVendorPrice(Long vendorId);

	VendorWeightPriceUpdateDTO updateVendorWeightandPrice(Long vendorPriceWeightId,
			VendorWeightPriceUpdateDTO vendorWeightPrice);

}
