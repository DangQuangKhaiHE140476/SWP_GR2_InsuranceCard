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
		repo.save(user);
	}
	
	public void deleteStaff(String id) {
		repo.deleteStaff(id);
	}
	
	public ArrayList<User> viewAllStaff(){
		return repo.getAllStaff();
	}
	
	public ArrayList<User> viewStaff(String id){
		return repo.getStaff(id);
	}
}
