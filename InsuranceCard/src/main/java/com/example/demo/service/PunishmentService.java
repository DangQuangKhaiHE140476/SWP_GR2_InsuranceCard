package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PunishmentRepo;
import com.example.demo.model.Punishment;

@Service
public class PunishmentService {
	private final PunishmentRepo repo;

	public PunishmentService(PunishmentRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<Punishment> getPunishmentByContractID(String id){
		return repo.getPunishmentByContractID(id);
	}
	
	public ArrayList<Punishment> getPunishmentByID(String id){
		return repo.getPunishmentByID(id);
	}
}
