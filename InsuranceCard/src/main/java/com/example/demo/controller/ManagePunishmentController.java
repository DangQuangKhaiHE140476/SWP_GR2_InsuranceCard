package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contract;
import com.example.demo.model.Punishment;
import com.example.demo.service.ContractUserService;
import com.example.demo.service.PunishmentService;
@Controller
public class ManagePunishmentController {
	private final ContractUserService contractService;
	private final PunishmentService punishmentService;
	@Autowired
	public ManagePunishmentController(ContractUserService contractService, PunishmentService punishmentService) {
		super();
		this.contractService = contractService;
		this.punishmentService = punishmentService;
	}
	
	@RequestMapping("/punishmenthistory")
	public ModelAndView getPunishmentByUser() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Contract> contract = contractService.getContractByUserID();
		ArrayList<Punishment> p = new ArrayList<Punishment>();
		for (Contract contract2 : contract) {
			p.addAll(punishmentService.getPunishmentByContractID(contract2.getId().toString()));
		}
		mv.addObject("punishments", p);
		mv.setViewName("punishmenthistory");
		return mv;
	}
	
	@RequestMapping("/punishmentdetail")
	public ModelAndView getPunishmentByID(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Punishment> p = punishmentService.getPunishmentByID(id);
		mv.addObject("punishment", p);
		mv.setViewName("punishmentdetail");
		return mv;
	}
}
