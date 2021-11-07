package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccidentRepo;
import com.example.demo.model.Accident;

@Service
public class AccidentService {
	private final AccidentRepo repo;
	@Autowired
	public AccidentService(AccidentRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<Accident> getAccidentByContractID(String id){
		return repo.getAccidentByContractID(id);
	}
}
