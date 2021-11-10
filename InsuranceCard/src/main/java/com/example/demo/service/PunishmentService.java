package com.example.demo.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractRepo;
import com.example.demo.dao.PunishmentRepo;
import com.example.demo.dao.PunishmentStatusRepo;
import com.example.demo.model.Contract;
import com.example.demo.model.Punishment;
import com.example.demo.model.PunishmentStatus;

@Service
public class PunishmentService {
	private final PunishmentRepo repo;
	private final ContractRepo contractRepo;
	private final PunishmentStatusRepo punishmentStatusRepo;

	@Autowired
	public PunishmentService(PunishmentRepo repo, ContractRepo contractRepo,
			PunishmentStatusRepo punishmentStatusRepo) {
		super();
		this.repo = repo;
		this.contractRepo = contractRepo;
		this.punishmentStatusRepo = punishmentStatusRepo;
	}

	public void addPunishment(Punishment p) {
		repo.save(p);
	}
	
	public ArrayList<Punishment> getPunishmentByContractID(String id){
		return repo.getPunishmentByContractID(id);
	}
	
	public ArrayList<Punishment> getPunishmentByID(String id){
		return repo.getPunishmentByID(id);
	}
	
	public void addContractPunishment(String contractid, String amount, String reason, String deadline) {
		String timestamp = deadline.replace("T", " ");
		timestamp = timestamp.concat(":00");
        Timestamp ts = Timestamp.valueOf(timestamp);
		Contract c = contractRepo.getContractByID(contractid).get(0);
		PunishmentStatus ps = punishmentStatusRepo.getPunishMentTypePaid("UNPAID").get(0);
		Punishment p = new Punishment();
		p.setContract(c);
		p.setAmount(Integer.parseInt(amount));
		p.setReason(reason);
		p.setDeadline(ts);
		p.setPunishmentStatus(ps);
		repo.save(p);
	}
	
	public void editContractPunishment(String id, String amount, String reason, String deadline) {
		String formated_deadline = deadline.replace("T", " ").concat(":00");
		repo.editPunishment(amount, formated_deadline, reason, id);
	}
}
