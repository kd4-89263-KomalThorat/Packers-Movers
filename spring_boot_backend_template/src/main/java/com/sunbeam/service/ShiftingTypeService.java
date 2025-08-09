package com.sunbeam.service;

import java.util.List;
import java.util.Optional;

import com.sunbeam.dao.ShiftingTypeDao;
import com.sunbeam.dto.ShiftingTypeDTO;
import com.sunbeam.pojos.ShiftingType;

public interface ShiftingTypeService {
	 public ShiftingType addShiftingType(ShiftingTypeDTO shiftingDto);
	 public List<ShiftingType> getAllShiftingTypes();
	 public Optional<ShiftingType> getShiftingTypeByName(String name);

}