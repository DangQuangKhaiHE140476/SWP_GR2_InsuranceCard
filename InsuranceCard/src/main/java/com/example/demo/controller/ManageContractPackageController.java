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
public class ManageContractPackageController {

	private final PackageService packageService;
	private final VehicleTypeService vehicleTypeService;
	private final InsuranceTypeService insuranceTypeService;
	private final InsuranceLiabilityService insuranceLiabilityService;
	
	@Autowired
	public ManageContractPackageController(PackageService packageService, VehicleTypeService vehicleTypeService,
			InsuranceTypeService insuranceTypeService, InsuranceLiabilityService insuranceLiabilityService) {
		super();
		this.packageService = packageService;
		this.vehicleTypeService = vehicleTypeService;
		this.insuranceTypeService = insuranceTypeService;
		this.insuranceLiabilityService = insuranceLiabilityService;
	}
	
	@RequestMapping("/contractpackagelist")
	public ModelAndView ContractPackageList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("packageList", packageService.getAllPackages());
		mv.setViewName("contractpackagelist");
		return mv;
	}
	
	@RequestMapping("/contractpackage{id}")
	public ModelAndView ContractPackage(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("package", packageService.getPackageById(id));
		mv.setViewName("contractpackage");
		return mv;
	}
	
	@RequestMapping("/requestnewcontract{id}")
	public ModelAndView RequestNewContract(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vehicleTypes", vehicleTypeService.getAllVehicleType());
		mv.addObject("package", packageService.getPackageById(id));
		mv.setViewName("requestnewcontract");
		return mv;
	}
}
