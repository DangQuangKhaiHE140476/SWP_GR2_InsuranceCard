package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PaymentTypeRepo;
import com.example.demo.model.PaymentType;

@Service
public class PaymentTypeService {
	private final PaymentTypeRepo repo;
	@Autowired
	public PaymentTypeService(PaymentTypeRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<PaymentType> getPaymentType(String type){
		return repo.getPaymentType(type);
	}
}
