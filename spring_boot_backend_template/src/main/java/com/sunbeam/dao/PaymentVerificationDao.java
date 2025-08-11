package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.PaymentVerification;


public interface PaymentVerificationDao {
	Optional<PaymentVerification> findByPaymentId(String paymentId);

}
