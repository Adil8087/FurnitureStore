package com.OnWeb.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.OnWeb.demo.repo.IPaymentRepo;

public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	IPaymentRepo iPaymentRepo;
}
