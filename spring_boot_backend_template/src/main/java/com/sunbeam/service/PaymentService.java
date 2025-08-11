package com.sunbeam.service;

import com.sunbeam.dto.PaymentOrderDto;

public interface PaymentService {
	PaymentOrderDto createOrder(Long userId,Long vendorId,Double Amount,String Currency) throws RazorpayException;
	PaymentOrderDto getOrderByRazorpayId(String razorpayOrderId);
	PaymentOrderDto updateOrderStatus(String razorpayOrderId,String paymentId,String status);

}
