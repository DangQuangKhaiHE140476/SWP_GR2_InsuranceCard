package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.InsuranceLiabilityService;

@Controller
public class ManageInsuranceLiabilityController {
	private final InsuranceLiabilityService liabilityService;

	@Autowired
	public ManageInsuranceLiabilityController(InsuranceLiabilityService liabilityService) {
		super();
		this.liabilityService = liabilityService;
	}
	
	@RequestMapping("/showliability")
	public ModelAndView getAllLiabilities() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("liabilities", liabilityService.getAllInsuranceLiabilities());
		mv.setViewName("showliabilities");
		return mv;
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
	
	@RequestMapping("/viewaddliability")
	public ModelAndView viewAddStaff() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addliability");
		return mv;
	}
	
	@RequestMapping("/addliability")
	public ModelAndView addNewLiability(@RequestParam("leveldamage") String leveldamage, @RequestParam("compensationamount") String compensationamount) {
		liabilityService.addNewLiability(leveldamage,compensationamount);
		return new ModelAndView("redirect:/showliability");
	}
}
