package com.example.demo.service;

import java.sql.Date; 
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContractRepo;
import com.example.demo.dao.ContractStatusRepo;
import com.example.demo.dao.PackageRepo;
import com.example.demo.dao.PaymentRepo;
import com.example.demo.dao.PaymentTypeRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.dao.VehicleRepo;
import com.example.demo.dao.VehicleTypeRepo;
import com.example.demo.model.Contract;
import com.example.demo.model.ContractStatus;
import com.example.demo.model.Vehicle;
import com.example.demo.model.Package;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentType;
import com.example.demo.model.User;

@Service
public class ContractService {

	private final ContractRepo contractRepo;
	private final VehicleTypeRepo vehicleTypeRepo;
	private final PackageRepo packageRepo;
	private final ContractStatusRepo contractStatusRepo;
	private final UserRepo userRepo;
	private final VehicleRepo vehicleRepo;
	private final PaymentTypeRepo paymentTypeRepo;
	private final PaymentRepo paymentRepo;

	@Autowired
    public ContractService(ContractRepo contractRepo, VehicleTypeRepo vehicleTypeRepo, PackageRepo packageRepo,
			ContractStatusRepo contractStatusRepo, UserRepo userRepo, VehicleRepo vehicleRepo,
			PaymentTypeRepo paymentTypeRepo, PaymentRepo paymentRepo) {
		super();
		this.contractRepo = contractRepo;
		this.vehicleTypeRepo = vehicleTypeRepo;
		this.packageRepo = packageRepo;
		this.contractStatusRepo = contractStatusRepo;
		this.userRepo = userRepo;
		this.vehicleRepo = vehicleRepo;
		this.paymentTypeRepo = paymentTypeRepo;
		this.paymentRepo = paymentRepo;
	}

	public Timestamp getCurrentDate() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return ts;
	}
	
	public ArrayList<Contract> getAllUserContract(String id){
		return contractRepo.getAllContractByUserID(id);
	}
	
	public Contract getContractById(String id) {
		return contractRepo.getContractByID(id).get(0);
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
		
		PaymentType pt = paymentTypeRepo.getPaymentType("NEW_CONTRACT").get(0);
		Payment pm = new Payment();
		pm.setContract(c);
		pm.setPaymentType(pt);
		pm.setPaymentdate(getCurrentDate());
		paymentRepo.save(pm);
		
		
	}
}
