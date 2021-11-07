package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CompensationRepo;

@Service
public class CompensationService {
	private final CompensationRepo repo;
	@Autowired
	public CompensationService(CompensationRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	
}
