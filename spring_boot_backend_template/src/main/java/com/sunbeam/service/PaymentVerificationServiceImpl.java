package com.sunbeam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.sunbeam.dao.PaymentOrderDao;
import com.sunbeam.dao.PaymentVerificationDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.PaymentVerificationDto;
import com.sunbeam.pojos.PaymentOrder;
import com.sunbeam.pojos.PaymentVerification;
import com.sunbeam.pojos.User;

public class PaymentVerificationServiceImpl {

    @Autowired
    private PaymentVerificationDao paymentVerifyingDao;
    
    @Autowired
    private PaymentOrderDao paymentOrderDao;  // ✅ Added PaymentOrderDao

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private VendorDao vendorDao;
    
    @Value("${razorpay.key_id}")
    private String razorPayKeyId;

    @Value("${razorpay.key_secret}")
    private String razorPaySecretId;

	@Override
	public PaymentVerificationDto verifyPayment(String paymentId) throws RazorpayException {
		 RazorpayClient razorpay = new RazorpayClient(razorPayKeyId, razorPaySecretId);

	        
	        Payment payment = razorpay.payments.fetch(paymentId);
	        String razorpayOrderId = payment.get("order_id");
	        String status = payment.get("status");
	        Double amount = ((Number) payment.get("amount")).doubleValue() / 100.0;  // ✅ Convert Integer to Double

	        System.out.println("Verifying Payment: " + paymentId + " | Status: " + status);

	      
	        Optional<PaymentVerification> existingPayment = paymentVerifyingDao.findByPaymentId(paymentId);
	        if (existingPayment.isPresent()) {
	            System.out.println("Payment Already Verified: " + paymentId);
	            return new PaymentVerificationDto(existingPayment.get());
	        }

	      
	        PaymentOrder paymentOrder = paymentOrderDao.findByRazorpayOrderId(razorpayOrderId)
	                .orElseThrow(() -> new RuntimeException("Order Not Found for Razorpay Order ID: " + razorpayOrderId));

	        User user = paymentOrder.getUser(); 
	        Vendor vendor = paymentOrder.getVendor();  

	       
	        PaymentVerification paymentVerification = new PaymentVerification();
	        paymentVerification.setUser(user);
	        paymentVerification.setVendor(vendor);
	        paymentVerification.setRazorpayOrderId(razorpayOrderId);
	        paymentVerification.setPaymentId(paymentId);
	        paymentVerification.setCurrency("INR");
	        paymentVerification.setAmount(amount);
	        paymentVerification.setStatus(status);

	        paymentVerification = paymentVerifyingDao.save(paymentVerification);

	        return new PaymentVerificationDto(paymentVerification);
	}

   
}
