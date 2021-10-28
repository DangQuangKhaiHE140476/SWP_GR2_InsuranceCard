package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InsuranceTypeRepo;
import com.example.demo.model.InsuranceType;

@Service
public class InsuranceTypeService {

	private final InsuranceTypeRepo insuranceTypeRepo;

	@Autowired
	public InsuranceTypeService(InsuranceTypeRepo insuranceTypeRepo) {
		super();
		this.insuranceTypeRepo = insuranceTypeRepo;
	}
	
	public List<InsuranceType> getAllInsuranceType(){
		return insuranceTypeRepo.findAll();
	}
	
}
