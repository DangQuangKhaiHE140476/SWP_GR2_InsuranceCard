package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RequestRepo;
import com.example.demo.model.Request;

@Service
public class RequestService {
	private final RequestRepo repo;
	@Autowired
	public RequestService(RequestRepo repo) {
		super();
		this.repo = repo;
	}
	
	public void addRequest(Request request) {
		 repo.save(request);
	}
}
