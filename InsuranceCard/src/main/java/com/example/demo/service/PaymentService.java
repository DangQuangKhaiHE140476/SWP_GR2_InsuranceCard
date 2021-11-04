package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PaymentRepo;
import com.example.demo.model.Payment;

@Service
public class PaymentService {
	private final PaymentRepo repo;
	@Autowired
	public PaymentService(PaymentRepo repo) {
		super();
		this.repo = repo;
	}
	
	public void addPayment(Payment p) {
		repo.save(p);
	}
}
