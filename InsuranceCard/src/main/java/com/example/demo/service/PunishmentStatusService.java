package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PunishmentStatusRepo;
import com.example.demo.model.PunishmentStatus;

@Service
public class PunishmentStatusService {
	private final PunishmentStatusRepo repo;
	@Autowired
	public PunishmentStatusService(PunishmentStatusRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ArrayList<PunishmentStatus> getPaymentStatusPaid(String type){
		return repo.getPunishMentTypePaid(type);
	}
}
