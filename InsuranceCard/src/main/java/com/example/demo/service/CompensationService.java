package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccidentRepo;
import com.example.demo.dao.CompensationRepo;
import com.example.demo.dao.CompensationStatusRepo;
import com.example.demo.dao.InsuranceLiabilityRepo;
import com.example.demo.dao.RequestRepo;
import com.example.demo.model.Compensation;
import com.example.demo.model.InsuranceLiability;

@Service
public class CompensationService {
	private final CompensationRepo compensationRepo;
	private final CompensationStatusRepo compensationStatusRepo;
	private final InsuranceLiabilityRepo insuranceLiabilityRepo;
	private final AccidentRepo accidentRepo;
	private final RequestRepo requestRepo;
	
	@Autowired
	public CompensationService(CompensationRepo compensationRepo, CompensationStatusRepo compensationStatusRepo,
			InsuranceLiabilityRepo insuranceLiabilityRepo, AccidentRepo accidentRepo,RequestRepo requestRepo) {
		this.compensationRepo = compensationRepo;
		this.compensationStatusRepo = compensationStatusRepo;
		this.insuranceLiabilityRepo = insuranceLiabilityRepo;
		this.accidentRepo = accidentRepo;
		this.requestRepo = requestRepo;
	}
	
	public ArrayList<Compensation> getAllCompensation() {
		return (ArrayList<Compensation>) compensationRepo.findAll();
	}
	
	

	public void addCompensationForAccident(String id, String [] liabilities) {
		ArrayList<InsuranceLiability> liabilityList = new ArrayList<InsuranceLiability>();
		ArrayList<InsuranceLiability> item;
		for(String liability:liabilities) {
			item = insuranceLiabilityRepo.getLiability(liability);
			liabilityList.add(item.get(0));
		}
		Compensation c = new Compensation();
	    
		c.setAccident(accidentRepo.getAccidentByID(id).get(0));
		c.setCompensationStatus(compensationStatusRepo.getUNPAIDCompensationStatus().get(0));
		c.setInsuranceLiabilities(liabilityList);
		
		compensationRepo.save(c);
	}
	
	public ArrayList<Compensation> getCompensationByID(String id) {
		return compensationRepo.getCompensationByID(id);
	}

	public void resolveCompensation(String id) {
		//resolve request
		//getCompensationByID(id).get(0).getAccident().getContract().getId().toString() -> cái này là contract id của compensation này
		requestRepo.resolveCompensationRequest(getCompensationByID(id).get(0).getAccident().getContract().getId().toString());
		
		//update compensation status = paid
		//getCompensationByID(id).get(0).getAccident().getId().toString() -> cái này là accident id của compensation
		compensationRepo.paidCompensation(getCompensationByID(id).get(0).getAccident().getId().toString());
		
	}
	
}
