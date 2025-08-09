package com.sunbeam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sunbeam.dao.ShiftingTypeDao;
import com.sunbeam.dto.ShiftingTypeDTO;

import com.sunbeam.pojos.ShiftingType;

public class ShiftingTypeServiceImpl implements ShiftingTypeService{

	
	 @Autowired
	    private ShiftingTypeDao shiftingTypeRepository;
	 
	@Override
	public ShiftingType addShiftingType(ShiftingTypeDTO shiftingTypeDTO) {
		ShiftingType shiftingType = new ShiftingType();
        shiftingType.setShiftingTypeName(shiftingTypeDTO.getShiftingTypeName());
        shiftingType.setShiftingTypeDesc(shiftingTypeDTO.getShiftingTypeDesc());
        return shiftingTypeRepository.save(shiftingType);
    }

	@Override
	public List<ShiftingType> getAllShiftingTypes() {
	
		return shiftingTypeRepository.findAll();
	}

	@Override
	public Optional<ShiftingType> getShiftingTypeByName(String name) {
		
		return shiftingTypeRepository.findByShiftingTypeName(name);
	}
	
}
