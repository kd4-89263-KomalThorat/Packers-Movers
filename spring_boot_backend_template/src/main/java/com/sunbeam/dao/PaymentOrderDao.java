package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.PaymentOrder;

public interface PaymentOrderDao extends JpaRepository<PaymentOrder, Long> {
	Optional<PaymentOrder>findByRazorpayOrderId(String razorpayOrderId);
	}
