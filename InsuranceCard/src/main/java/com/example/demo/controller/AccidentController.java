package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Accident;
import com.example.demo.service.AccidentService;
import com.example.demo.service.CompensationService;

@Controller
public class AccidentController {
	private final AccidentService accidentService;
	private final CompensationService compensationService;
	
	@Autowired
	public AccidentController(AccidentService accidentService, CompensationService compensationService) {
		this.accidentService = accidentService;
		this.compensationService = compensationService;
	}

	@RequestMapping("/reportaccident")
	public ModelAndView requestAccident() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reportaccident");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/report")
	public ModelAndView addRequestAccident(Accident accident) {
		accidentService.addAccident(accident);
		return new ModelAndView("redirect:/accidenthistory");
	}
	
	@RequestMapping("/reportedaccidentlist")
	public ModelAndView getReportedAccidentList() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("accidentList",accidentService.getAllAcident());
		mv.setViewName("reportedaccidentlist");
		return mv;
	}
	
	@RequestMapping("/verifyaccident{id}")
	public ModelAndView verifyAccident(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("accident", accidentService.getAcidentByID(id).get(0));
		mv.setViewName("verifyaccident");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/approve")
	public String approve(
			@RequestParam("id") String id,
			@RequestParam("liabilities") String []	 liabilities) {
		
		//accident status = approve
		accidentService.approve(id);
		//add compensation for the accident
		compensationService.addCompensationForAccident(id, liabilities);
		
		return "redirect:/reportedaccidentlist";
	}
	
	@RequestMapping("/reject")
	public String reject(
			@RequestParam("id") String id) {
		
		//accident status = reject
		accidentService.reject(id);
		
		return "redirect:/reportedaccidentlist";
	}
	
}
