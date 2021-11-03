package com.example.demo.service;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractRepo;
import com.example.demo.dao.ContractStatusRepo;
import com.example.demo.dao.PackageRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.dao.VehicleRepo;
import com.example.demo.dao.VehicleTypeRepo;
import com.example.demo.model.Contract;
import com.example.demo.model.ContractStatus;
import com.example.demo.model.Vehicle;
import com.example.demo.model.Package;
import com.example.demo.model.User;

@Service
public class ContractService {

	private final ContractRepo contractRepo;
	private final VehicleTypeRepo vehicleTypeRepo;
	private final PackageRepo packageRepo;
	private final ContractStatusRepo contractStatusRepo;
	private final UserRepo userRepo;
	private final VehicleRepo vehicleRepo;

	@Autowired
    public ContractService(ContractRepo contractRepo, VehicleTypeRepo vehicleTypeRepo, PackageRepo packageRepo,
			ContractStatusRepo contractStatusRepo, UserRepo userRepo, VehicleRepo vehicleRepo) {
		super();
		this.contractRepo = contractRepo;
		this.vehicleTypeRepo = vehicleTypeRepo;
		this.packageRepo = packageRepo;
		this.contractStatusRepo = contractStatusRepo;
		this.userRepo = userRepo;
		this.vehicleRepo = vehicleRepo;
	}

	public Timestamp getCurrentDate() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return ts;
	}
	
	public String getUserName(String id) {
		User u = userRepo.getCustomer(id).get(0);
		String name = u.getName();
		return name;
	}

	public void RequestNewContract(String userid,
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
		vehicleRepo.save(v);
		
		Package p = packageRepo.getById(Long.parseLong(packageid));
		ContractStatus cs = contractStatusRepo.getById(Long.valueOf("1"));
		User u = userRepo.getCustomer(userid).get(0);
		
		Contract c = new Contract();
		c.setUser(u);
		c.setVehicle(v);
		c.setPackage_(p);
		c.setCreationdate(getCurrentDate());
		c.setContractStatus(cs);
		contractRepo.save(c);
	}
}
