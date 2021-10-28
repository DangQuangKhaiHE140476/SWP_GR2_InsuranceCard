package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InsuranceLiabilityRepo;
import com.example.demo.model.InsuranceLiability;

@Service
public class InsuranceLiabilityService {
	private final InsuranceLiabilityRepo repo;

	@Autowired
	public InsuranceLiabilityService(InsuranceLiabilityRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<InsuranceLiability> getAllInsuranceLiability(){
		return (ArrayList<InsuranceLiability>) repo.findAll();
	}
	
	public ArrayList<InsuranceLiability> getLiability(String id){
		return repo.getLiability(id);
	}
	
	public void updateLiability(String id, String leveldamage, String compensationamount) {
		//insert validate String here
		
			//validate compensationamount must be a number
			//validate boundary value
		
		repo.updateLiability(id, leveldamage, compensationamount);
	}
	
	public void addNewLiability(InsuranceLiability liability) {
		//insert validate String here
		
			//validate compensationamount must be a number
			//validate boundary value
		
		repo.save(liability);
	}

	public void deleteLiability(String id) {
		repo.deleteLiability(id);
	}
}
