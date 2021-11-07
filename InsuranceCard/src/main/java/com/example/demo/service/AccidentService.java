package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccidentRepo;
import com.example.demo.dao.AccidentStatusRepo;
import com.example.demo.model.Accident;
import com.example.demo.model.AccidentStatus;
import com.example.demo.model.Contract;

@Service
public class AccidentService {
	private final AccidentRepo accidentRepo;
	private final AccidentStatusRepo accidentStatusRepo;
	
	
	@Autowired
	public AccidentService(AccidentRepo accidentRepo, AccidentStatusRepo accidentStatusRepo) {
		this.accidentRepo = accidentRepo;
		this.accidentStatusRepo = accidentStatusRepo;
	}
	
	@Autowired
	private HttpSession session;

	public ArrayList<Accident> getAccidentByContractID(String id){
		return accidentRepo.getAccidentByContractID(id);
	}
	
	public void addAccident(Accident accident){
		List<AccidentStatus> accidentStatusList = accidentStatusRepo.findAll();
		for (AccidentStatus accidentStatus : accidentStatusList) {
			if(accidentStatus.getId()==3L) {
				accident.setAccidentStatus(accidentStatus);
				break;
			}
		}
		
		Contract contract = (Contract) session.getAttribute("contract");
		accident.setContract(contract);
		accidentRepo.save(accident);
	}
}
