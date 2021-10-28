package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VehicleTypeRepo;
import com.example.demo.model.VehicleType;

@Service
public class VehicleTypeService {

	private final VehicleTypeRepo vehicleTypeRepo;

	@Autowired
	public VehicleTypeService(VehicleTypeRepo vehicleTypeRepo) {
		super();
		this.vehicleTypeRepo = vehicleTypeRepo;
	}
	
	public List<VehicleType> getAllVehicleType(){
		return vehicleTypeRepo.findAll();
	}
}
