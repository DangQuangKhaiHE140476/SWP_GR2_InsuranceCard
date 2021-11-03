package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RequestStatusRepo;
import com.example.demo.model.RequestStatus;

@Service
public class RequestStatusService {
	private final RequestStatusRepo repo;
	@Autowired
	public RequestStatusService(RequestStatusRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<RequestStatus> getRequestStatusByStatus(String status){
		return repo.getRequestStatus(status);
	}
}
