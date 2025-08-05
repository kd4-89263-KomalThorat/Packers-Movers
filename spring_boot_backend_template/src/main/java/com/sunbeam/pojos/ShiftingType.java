package com.sunbeam.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SHIFTING_TYPE")
@NoArgsConstructor
@Getter
@Setter
public class ShiftingType extends BaseEntity {
	 @Column(name = "ShiftingTypeName", unique = true, nullable = false, length = 255)
	 private String shiftingTypeName;

	  @Column(name = "ShiftingTypeDesc", nullable = false, length = 150)
	  private String shiftingTypeDesc;
}
