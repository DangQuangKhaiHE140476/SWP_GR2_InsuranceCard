package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

@Service
public class UserService {
	
	private final UserRepo repo;
	
	@Autowired
	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
	}
	
	public void addNewStaff(User user) {
		//validate input for
			//boundary (for length) of ssn, address, phone, email
			//phone, ssn must contain only numbers
			//use regex for email
		repo.save(user);
	}
	
	public void deleteStaff(String id) {
		repo.deleteStaff(id);
	}
	
	public ArrayList<User> viewAllStaff(){
		//DOB is currently in yyyy/MM/dd format, change it to dd/MM/yyyy
		//assign those formated information to objects, add objects to arraylist then return it, dont return getAllStaff like this
		return repo.getAllStaff();
	}
	
	public ArrayList<User> viewStaff(String id){
		//same as viewAllStaff
		return repo.getStaff(id);
	}
	
	public ArrayList<User> getUser(String id){
		return repo.getUser(id);
	}
	//add a method for update, with validate as addNewStaff
}
