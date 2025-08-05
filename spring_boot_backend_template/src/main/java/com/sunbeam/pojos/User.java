package com.sunbeam.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
	@Column(name = "full_name", length = 100) 
	private String fullName;
	
	@Column(length = 50, unique = true) 
	private String email;
	
	@Column(length = 20, nullable = false) 
	private String password;
	
	@Column(length = 15, nullable = false) 
	private String phone;
	
	@Column(length = 100, nullable = false) 
	private String address;
	
	@Column(length = 80, nullable = false) 
	private String city;
	
	@Enumerated(EnumType.STRING) 
	@Column(length = 30) 
    private UserRole role;
	
	@Column(name="delete_status")
	boolean deleteStatus;
	

}
