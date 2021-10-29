package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleRepo;
import com.example.demo.model.Role;

@Service
public class RoleService {
	private final RoleRepo repo;
	@Autowired
	public RoleService(RoleRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<Role> getAllRole(){
		return (ArrayList<Role>)repo.findAll();
	}
	
}
