package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.ShiftingType;

public interface ShiftingTypeDao extends JpaRepository<ShiftingType,Long>{
	Optional<ShiftingType> findByShiftingTypeName(String shiftingTypename);

}
