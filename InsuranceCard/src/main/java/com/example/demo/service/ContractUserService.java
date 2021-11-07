package com.example.demo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractRepo;
import com.example.demo.model.Contract;
import com.example.demo.model.User;

@Service
public class ContractUserService {
	private final ContractRepo repo;
	@Autowired
	public ContractUserService(ContractRepo repo) {
		super();
		this.repo = repo;
	}
	@Autowired
	private HttpSession session;
	
	public ArrayList<Contract> getContractByCurrentUserID(){
		User user = (User) session.getAttribute("user");
		return repo.getContractByUserID(user.getId().toString());
	}
	
	public ArrayList<Contract> getContractByID(String id){
		return (ArrayList<Contract>) repo.getContractByID(id);
	}
	
	public void saveContract(Contract c) {
		repo.save(c);
	}
}
