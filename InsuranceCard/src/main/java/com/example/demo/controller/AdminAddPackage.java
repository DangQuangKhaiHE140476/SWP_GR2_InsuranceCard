package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InsuranceLiabilityService;
import com.example.demo.service.InsuranceTypeService;
import com.example.demo.service.PackageService;
import com.example.demo.service.VehicleTypeService;

@Controller
public class AdminAddPackage {
	private final PackageService packageService;
	private final VehicleTypeService vehicleTypeService;
	private final InsuranceTypeService insuranceTypeService;
	private final InsuranceLiabilityService insuranceLiabilityService;
	
	@Autowired
	public AdminAddPackage(PackageService packageService, VehicleTypeService vehicleTypeService,
			InsuranceTypeService insuranceTypeService, InsuranceLiabilityService insuranceLiabilityService) {
		super();
		this.packageService = packageService;
		this.vehicleTypeService = vehicleTypeService;
		this.insuranceTypeService = insuranceTypeService;
		this.insuranceLiabilityService = insuranceLiabilityService;
	}
	
	@RequestMapping("/addpackage")
	public ModelAndView AddPackage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vehicleTypes", vehicleTypeService.getAllVehicleType());
		mv.addObject("insuraceTypes", insuranceTypeService.getAllInsuranceType());
		mv.addObject("insuranceLiabilities", insuranceLiabilityService.getAllInsuranceLiability());
		mv.setViewName("addpackage");
		return mv;
	}
	
	@RequestMapping("/add")
	public String Add(
			@RequestParam("VehicleType") String VehicleType,
			@RequestParam("Price") String Price,
			@RequestParam("Duration") String Duration,
			@RequestParam("InsuranceType") String InsuranceType,
			@RequestParam("liabilities") String [] liabilities) {
		
		packageService.addPackage(VehicleType, Price, Duration, InsuranceType, liabilities);
		return "redirect:/showpackagelist";
	}
}
