package com.example.demo.service;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractRepo;
import com.example.demo.dao.ContractStatusRepo;
import com.example.demo.dao.PackageRepo;
import com.example.demo.dao.VehicleTypeRepo;
import com.example.demo.model.Contract;
import com.example.demo.model.ContractStatus;
import com.example.demo.model.Vehicle;
import com.example.demo.model.Package;

@Service
public class ContractService {

	private final ContractRepo contractRepo;
	private final VehicleTypeRepo vehicleTypeRepo;
	private final PackageRepo packageRepo;
	private final ContractStatusRepo contractStatusRepo;

	@Autowired
	public ContractService(ContractRepo contractRepo, VehicleTypeRepo vehicleTypeRepo, PackageRepo packageRepo,
			ContractStatusRepo contractStatusRepo) {
		super();
		this.contractRepo = contractRepo;
		this.vehicleTypeRepo = vehicleTypeRepo;
		this.packageRepo = packageRepo;
		this.contractStatusRepo = contractStatusRepo;
	}

	public void RequestNewContract(String userid,
			String createdate,
			String ownername,
			String vehicletype,
			String brand,
			String model,
			String color,
			String registerdate,
			String chassisnember,
			String licienseplate,
			String packageid) {
        Date date = Date.valueOf(registerdate);
		Vehicle v = new Vehicle();
		v.setOwnername(ownername);
		v.setVehicleType(vehicleTypeRepo.getById(Long.parseLong(vehicletype)));
		v.setBrand(brand);
		v.setModel(model);
		v.setColor(color);
		v.setRegistrationdate(date);;
		v.setChassisnumber(chassisnember);
		v.setLicenseplates(licienseplate);
		
		Package p = packageRepo.getById(Long.parseLong(packageid));
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ContractStatus cs = contractStatusRepo.getById(Long.valueOf("1"));
		
		Contract c = new Contract();
		c.setUser(null);
		c.setVehicle(v);
		c.setPackage_(p);
		c.setCreationdate(ts);
		c.setContractStatus(cs);
	}
}
