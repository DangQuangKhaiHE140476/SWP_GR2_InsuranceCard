package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InsuranceLiabilityService;

@Controller
public class AdminShowInsuranceLiabilityList {
	private final InsuranceLiabilityService liabilityService;

	@Autowired
	public AdminShowInsuranceLiabilityList(InsuranceLiabilityService liabilityService) {
		super();
		this.liabilityService = liabilityService;
	}
	
	@RequestMapping("/showliability")
	public ModelAndView getAllLiabilities() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("liabilities", liabilityService.getAllInsuranceLiability());
		mv.setViewName("showliabilities");
		return mv;
	}
}
