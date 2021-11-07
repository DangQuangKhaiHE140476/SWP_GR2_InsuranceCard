package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractStatusRepo;
import com.example.demo.model.ContractStatus;
import com.example.demo.model.Request;

@Service
public class ContractStatusService {
	private final ContractStatusRepo repo;
	@Autowired
	public ContractStatusService(ContractStatusRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ContractStatus getContractStatusByID(String id){
		return (ContractStatus)repo.getById(Long.valueOf(id));
	}
	
}
