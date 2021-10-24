package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.customersRepo;
import com.example.demo.model.customers;
@Service
public class customersService {
	private final customersRepo repo;
	@Autowired
	public customersService(customersRepo repo) {
		super();
		this.repo = repo;
	}
	
	public void addNewStaff(customers cus) {
		repo.save(cus);
	}
	
	public void deleteStaff(String id) {
		repo.deleteStaff(id);
	}
	
	public void updateStaff() {
		
	}
	
	public ArrayList<customers> viewAllStaff(){
		return repo.getAllStaff();
	}
	
	public ArrayList<customers> viewStaff(String id){
		return repo.getStaff(id);
	}
	
	
}
