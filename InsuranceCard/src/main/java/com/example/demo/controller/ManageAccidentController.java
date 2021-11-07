package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Accident;
import com.example.demo.model.Contract;
import com.example.demo.model.Payment;
import com.example.demo.model.User;
import com.example.demo.service.AccidentService;
import com.example.demo.service.ContractUserService;

@Controller
public class ManageAccidentController {
	private final AccidentService accidentService;
	private final ContractUserService contractService;
	@Autowired
	public ManageAccidentController(AccidentService accidentService, ContractUserService contractService) {
		super();
		this.accidentService = accidentService;
		this.contractService = contractService;
	}
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/accidenthistory")
	public ModelAndView getAccidentByUsere() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<Contract> contract = contractService.getContractByUserID();
		ArrayList<Accident> accident = new ArrayList<Accident>();
		
		for (Contract contract2 : contract) {
			accident.addAll(accidentService.getAccidentByContractID(contract2.getId().toString()));
		}
		
		mv.addObject("accidents", accident);
		mv.setViewName("accidenthistory");
		return mv;
	}
	
	@RequestMapping("/compensationhistory")
	public ModelAndView getCompensationByAccident() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<Contract> contract = contractService.getContractByUserID();
		ArrayList<Accident> accident = new ArrayList<Accident>();
		
		for (Contract contract2 : contract) {
			accident.addAll(accidentService.getAccidentByContractID(contract2.getId().toString()));
		}
		
		mv.addObject("accidents", accident);
		mv.setViewName("compensationhistory");
		return mv;
		
	}
	
}
