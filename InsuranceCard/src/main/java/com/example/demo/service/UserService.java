package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.common.DateUtils;
import com.example.demo.common.StringUtils;
import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;

@Service
public class UserService {
	
	private final UserRepo repo;
	private final DateUtils dateUtils;
	private final StringUtils stringUtils;
	@Autowired
	public UserService(UserRepo repo, DateUtils dateUtils, StringUtils stringUtils) {
		this.repo = repo;
		this.dateUtils = dateUtils;
		this.stringUtils = stringUtils;
	}
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	

	public void addNewStaff(User user) {
		//validate input for
			//boundary (for length) of ssn, address, phone, email
			//phone, ssn must contain only numbers
			//use regex for email
		//Encrypt password before saving to DB
		String pass = passwordEncoder.encode(user.getPassword());
		user.setPassword(pass);
		
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

	public void updateUserProfile(
			String id, 
			String name, 
			String ssn, 
			String dob, 
			String gender, 
			String address, 
			String phonenumber, 
			String email) {
		
		Date sqlDateDOB = dateUtils.convertStringToSQLDate(dob);
		boolean parsedGender = stringUtils.convertStringToBoolean(gender);
		repo.updateUserProfile( name, ssn, sqlDateDOB, parsedGender, address, phonenumber, email,id);
	}
}
