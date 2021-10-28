package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InsuranceLiabilityService;

@Controller
public class AdminEditInsuranceLiability {
	private final InsuranceLiabilityService liabilityService;

	@Autowired
	public AdminEditInsuranceLiability(InsuranceLiabilityService liabilityService) {
		super();
		this.liabilityService = liabilityService;
	}
	
	@RequestMapping("/viewEditLiability{id}")
	public ModelAndView viewUpdateStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("liabilities",liabilityService.getLiability(id));
		mv.setViewName("editliability");
		return mv;
	}
	
	@RequestMapping("/updateLiability")
	public ModelAndView updateLiability(@RequestParam("id") String id,
			@RequestParam("leveldamage") String leveldamage,
			@RequestParam("compensationamount") String compensationamount) {
		
		liabilityService.updateLiability(id, leveldamage, compensationamount);
		return new ModelAndView("redirect:/showliability");
	}
}
