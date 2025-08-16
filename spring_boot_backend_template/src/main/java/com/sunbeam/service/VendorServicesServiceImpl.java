package com.sunbeam.service;



import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.ServicesDao;
import com.sunbeam.dao.VendorDao;
import com.sunbeam.dao.VendorServiceDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.VendorServiceDTO;
import com.sunbeam.dto.VendorServiceResDTO;
import com.sunbeam.pojos.Services;
import com.sunbeam.pojos.Vendor;
import com.sunbeam.pojos.VendorServices;

import  lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor

@Service
@Transactional
public class VendorServicesServiceImpl implements VendorServicesService 
{

    private final ServiceRequestServiceImpl serviceRequestServiceImpl;
	@Autowired
	private VendorServiceDao vendorServiceDao;
	
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private ServicesDao serviceDao;
	
	@Autowired
	private ModelMapper modelMapper;

    VendorServicesServiceImpl(ServiceRequestServiceImpl serviceRequestServiceImpl) {
        this.serviceRequestServiceImpl = serviceRequestServiceImpl;
    }

	@Override
	public ApiResponse addVendorService(VendorServiceDTO vendorServiceDto) {
		Vendor vendor = vendorDao.findById(vendorServiceDto.getVendorid()).orElseThrow(() -> new RuntimeException("Vendor not found with ID: " +vendorServiceDto.getVendorid()));
		Services service = serviceDao.findById(vendorServiceDto.getServicesid()).orElseThrow(() -> new RuntimeException("Vendor not found with ID: " +vendorServiceDto.getServicesid()));
		
		
		
		VendorServices vendorServiceEnity = new VendorServices();
		vendorServiceEnity.setServices(service);
		vendorServiceEnity.setVendor(vendor);
		vendorServiceEnity.setPrice(vendorServiceDto.getPrice());
		
		vendorServiceDao.save(vendorServiceEnity);
		
		return new ApiResponse("Added vendorService successfully !!!");

	}

	@Override
	public List<VendorServiceDTO> getAllServices() {
		return vendorServiceDao.findAll().stream().map(vendorService ->{
			VendorServiceDTO dto = new VendorServiceDTO();
			dto.setVendorid(vendorService.getVendor().getId());
			dto.setServicesid(vendorService.getServices().getId());
			dto.setPrice(vendorService.getPrice());
			return dto;
		}).toList();

			}

	@Override
	public List<VendorServiceResDTO> getAllServicesByVendorID(Long id) {
		List<VendorServices> services = vendorServiceDao.findByVendorIdWithServices(id);
			
		return services.stream().map(service -> {
			VendorServiceResDTO dto = new VendorServiceResDTO();
			dto.setVendorid(service.getVendor().getId());
			dto.setServicesName(service.getServices().getServiceName());
			dto.setPrice(service.getPrice());
			return dto;
		}).collect(Collectors.toList());
		
			}

	@Override
	public ApiResponse deleteVendorService(VendorServiceResDTO dto) {
		Services service = serviceDao.findByServiceName(dto.getServicesName())
                .orElseThrow(() -> new RuntimeException("Service not found!"));

        VendorServices vendorService = vendorServiceDao.findByVendorIdAndServicesId(dto.getVendorid(), service.getId())
                .orElseThrow(() -> new RuntimeException("Vendor Service not found!"));

        vendorServiceDao.delete(vendorService);

        return new ApiResponse("Vendor service deleted successfully for vendor ID: " + dto.getVendorid() +
                               " and service name: " + dto.getServicesName());
	}

	@Override
	public ApiResponse updatePrice(VendorServiceResDTO dto) {
		Services service = serviceDao.findByServiceName(dto.getServicesName())
                .orElseThrow(() -> new RuntimeException("Service not found!"));

        VendorServices vendorService = vendorServiceDao.findByVendorIdAndServicesId(dto.getVendorid(), service.getId()).orElseThrow(() -> new RuntimeException("Vendor Service not found!"));

        vendorService.setPrice(dto.getPrice());

        vendorServiceDao.save(vendorService);

        return new ApiResponse("Price updated successfully for vendor ID: " + dto.getVendorid() +
                               " and service name: " + dto.getServicesName());

	}
	

		


}