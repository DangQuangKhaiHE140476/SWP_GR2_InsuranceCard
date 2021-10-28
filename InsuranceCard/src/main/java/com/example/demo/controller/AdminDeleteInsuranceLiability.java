package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InsuranceLiabilityService;

@Controller
public class AdminDeleteInsuranceLiability {

	private final InsuranceLiabilityService liabilityService;

	@Autowired
	public AdminDeleteInsuranceLiability(InsuranceLiabilityService liabilityService) {
		super();
		this.liabilityService = liabilityService;
	}
	
	@RequestMapping("/deleteLiability")
	public ModelAndView deleteLiability(@RequestParam("id") String id) {
		liabilityService.deleteLiability(id);
		return new ModelAndView("redirect:/showliability"); 
	}
}
