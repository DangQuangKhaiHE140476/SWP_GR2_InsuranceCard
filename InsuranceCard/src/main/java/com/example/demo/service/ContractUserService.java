package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractRepo;
import com.example.demo.model.Contract;

@Service
public class ContractUserService {
	private final ContractRepo repo;
	@Autowired
	public ContractUserService(ContractRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<Contract> getContractByUserID(){
		Long id = 2L;
		return repo.getContractByUserID(id.toString());
	}
	
	public ArrayList<Contract> getContractByID(String id){
		return (ArrayList<Contract>) repo.getContractByID(id);
	}
}
