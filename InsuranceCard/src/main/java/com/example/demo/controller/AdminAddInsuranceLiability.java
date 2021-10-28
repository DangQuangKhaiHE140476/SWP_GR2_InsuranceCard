package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InsuranceLiabilityService;

@Controller
public class AdminAddInsuranceLiability {
	private final InsuranceLiabilityService liabilityService;

	@Autowired
	public AdminAddInsuranceLiability(InsuranceLiabilityService liabilityService) {
		super();
		this.liabilityService = liabilityService;
	}
	
	@RequestMapping("/viewaddliability")
	public ModelAndView viewAddStaff() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addliability");
		return mv;
	}
	
	@RequestMapping("/addliability")
	public ModelAndView addNewLiability(@RequestParam("leveldamage") String leveldamage, @RequestParam("compensationamount") String compensationamount) {
		liabilityService.addNewLiability(leveldamage, compensationamount);
		return new ModelAndView("redirect:/showliability");
	}
}
