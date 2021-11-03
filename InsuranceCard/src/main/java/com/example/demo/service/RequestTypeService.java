package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RequestTypeRepo;
import com.example.demo.model.RequestType;

@Service
public class RequestTypeService {
	private final RequestTypeRepo repo;
	@Autowired
	public RequestTypeService(RequestTypeRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<RequestType> getRequestTypeByType(String type){
		return repo.getRequestType(type);
	}
}
