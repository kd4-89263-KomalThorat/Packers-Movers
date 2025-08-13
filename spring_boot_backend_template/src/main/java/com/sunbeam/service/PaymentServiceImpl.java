package com.sunbeam.service;

import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.sunbeam.dao.PaymentOrderDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.VendorDao;
import com.sunbeam.dto.PaymentOrderDto;
import com.sunbeam.pojos.PaymentOrder;
import com.sunbeam.pojos.User;
import com.sunbeam.pojos.Vendor;

public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentOrderDao paymentOrderDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private VendorDao vendorDao;
	
	@Value("${razorpay.key_id}")
	private String razorPayKeyId;
	
	@Value("${razorpay.key_secret}")
	private String razorPaySecretId;
	

	@Override
    @Transactional
	public PaymentOrderDto createOrder(Long userId, Long vendorId, Double amount, String currency) throws RazorpayException 
	{
		RazorpayClient razorpay = new RazorpayClient(razorPayKeyId,razorPaySecretId);
		
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amount * 100);
		orderRequest.put("currency", currency);
		orderRequest.put("receipt", "Txn _"+System.currentTimeMillis());
		orderRequest.put("payment_capture",1);
		
		Order order = razorpay.orders.create(orderRequest);
		
		User user = userDao.findById(userId)
		        .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

		    Vendor vendor = vendorDao.findById(vendorId)
		        .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));
		
		PaymentOrder paymentOrder = new PaymentOrder();
		paymentOrder.setUser(user);
		paymentOrder.setVendor(vendor);
		paymentOrder.setRazorpayOrderId(order.get("id"));
		paymentOrder.setCurrency(currency);
		paymentOrder.setAmount(amount);
		paymentOrder.setStatus("Pending");
		
		paymentOrder = paymentOrderDao.save(paymentOrder);
		
		 return new PaymentOrderDto(paymentOrder);
		//return modelMapper.map(paymentOrder,PaymentOrderDto.class);
		
		
	}


	@Override
	public PaymentOrderDto getOrderByRazorpayId(String razorpayOrderId) {
		PaymentOrder paymentOrder = paymentOrderDao.findByRazorpayOrderId(razorpayOrderId).orElseThrow(()->new RuntimeException("Order Not Found RazorpayId :" +razorpayOrderId));
		//return modelMapper.map(paymentOrder, PaymentOrderDto.class);
		return new PaymentOrderDto(paymentOrder);
	}


	@Override
	public PaymentOrderDto updateOrderStatus(String razorpayOrderId,String paymentId, String status) 
	{
		PaymentOrder paymentOrder = paymentOrderDao.findByRazorpayOrderId(razorpayOrderId).orElseThrow(()->new RuntimeException("Order Not Found "+razorpayOrderId));
		
		paymentOrder.setPaymentId(paymentId);
		paymentOrder.setStatus(status);
		
		paymentOrder = paymentOrderDao.save(paymentOrder);
		return new PaymentOrderDto(paymentOrder);
	}
	
}
