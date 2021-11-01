package com.example.demo.service;

import java.util.ArrayList;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InsuranceLiabilityRepo;
import com.example.demo.dao.InsuranceTypeRepo;
import com.example.demo.dao.PackageRepo;
import com.example.demo.dao.VehicleTypeRepo;
import com.example.demo.model.InsuranceLiability;
import com.example.demo.model.Package;


@Service
public class PackageService {

	private final PackageRepo packageRepo;
	private final InsuranceLiabilityRepo insuranceLiabilityRepo;
	private final VehicleTypeRepo vehicleTypeRepo;
	private final InsuranceTypeRepo insuranceTypeRepo;

	@Autowired
	public PackageService(PackageRepo packageRepo, InsuranceLiabilityRepo insuranceLiabilityRepo,
			VehicleTypeRepo vehicleTypeRepo, InsuranceTypeRepo insuranceTypeRepo) {
		super();
		this.packageRepo = packageRepo;
		this.insuranceLiabilityRepo = insuranceLiabilityRepo;
		this.vehicleTypeRepo = vehicleTypeRepo;
		this.insuranceTypeRepo = insuranceTypeRepo;
	}
	
	public ArrayList<Package> getAllPackages(){
		return packageRepo.getAllPackage();
	}

	public Package getPackageById(String id) {
		return packageRepo.getPackageById(id).get(0);
	}
	
	public void addPackage(String VehicleType,
			String Price,
			String Duration,
			String InsuranceType,
			String [] liabilities) {
		
		ArrayList<InsuranceLiability> liabilityList = new ArrayList<InsuranceLiability>();
		ArrayList<InsuranceLiability> item;
		for(String liability:liabilities) {
			item = insuranceLiabilityRepo.getLiability(liability);
			liabilityList.add(item.get(0));
		}
		Package p = new Package();
	    
		p.setVehicleType(vehicleTypeRepo.getById(Long.parseLong(VehicleType)));
		p.setPrice(Integer.parseInt(Price));
		p.setDuration(Duration);
		p.setInsuranceType(insuranceTypeRepo.getById(Long.parseLong(InsuranceType)));
		p.setInsuranceLiabilities(liabilityList);
		packageRepo.save(p);
	}
}
