package com.sunbeam.service;

import com.sunbeam.dto.PaymentVerificationDto;
import com.razorpay.RazorpayException;


public interface PaymentVerificationService {
	PaymentVerificationDto verifyPayment (String paymentId) throws RazorpayException;

}
