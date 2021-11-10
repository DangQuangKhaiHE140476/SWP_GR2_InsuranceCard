package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contract;
import com.example.demo.model.Punishment;
import com.example.demo.service.ContractService;
import com.example.demo.service.PunishmentService;
import com.example.demo.service.UserService;

@Controller
public class ManageCustomer {

	private final UserService userService;
	private final ContractService contractService;
	private final PunishmentService punishmentSrevice;
    
	@Autowired
	public ManageCustomer(UserService userService, ContractService contractService,
			PunishmentService punishmentSrevice) {
		super();
		this.userService = userService;
		this.contractService = contractService;
		this.punishmentSrevice = punishmentSrevice;
	}

	@RequestMapping("/customerlist")
	public ModelAndView CustomerList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerlist", userService.getAllCustomer());
		mv.setViewName("customerlist");
		return mv;
	}
	
	@RequestMapping("/customerinfo")
	public ModelAndView CustomerInfo(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerinfo", userService.getCustomer(id));
		mv.setViewName("customerinfo");
		return mv;
	}
	
	@RequestMapping("/customercontractlist")
	public ModelAndView CustomerContractList(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contractlist", contractService.getAllUserContract(id));
		mv.setViewName("customercontractlist");
		return mv;
	}
	
	@RequestMapping("/customercontractdetail")
	public ModelAndView CustomerContractDetail(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contractdetail", contractService.getContractById(id));
		mv.setViewName("customercontractdetail");
		return mv;
	}
	
	@RequestMapping("/contractpunishment")
	public ModelAndView ContractPunishment(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("punishmentlist", punishmentSrevice.getPunishmentByContractID(id));
		mv.addObject("contractid", id);
		mv.setViewName("contractpunishment");
		return mv;
	}
	
	@RequestMapping("/addpunishment")
	public ModelAndView addPunishment(String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contractid", id);
		mv.setViewName("addpunishment");
		return mv;
	}
	
	@RequestMapping("/add_punishment_function")
	public ModelAndView addPunishmentFucntion(
			@RequestParam("contractid") String contractid,
			@RequestParam("amount") String amount,
			@RequestParam("reason") String reason,
			@RequestParam("deadline") String deadline) {
		ModelAndView mv = new ModelAndView();
		punishmentSrevice.addContractPunishment(contractid, amount, reason, deadline);
		mv.addObject("punishmentlist", punishmentSrevice.getPunishmentByContractID(contractid));
		mv.setViewName("contractpunishment");
		return mv;
	}
}
