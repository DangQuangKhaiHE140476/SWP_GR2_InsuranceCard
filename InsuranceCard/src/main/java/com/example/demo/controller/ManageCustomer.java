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
	public ModelAndView CustomerInfo(@RequestParam("userid") String userid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerinfo", userService.getCustomer(userid));
		mv.setViewName("customerinfo");
		return mv;
	}
	
	@RequestMapping("/customercontractlist")
	public ModelAndView CustomerContractList(@RequestParam("userid") String userid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerid", userid);
		mv.addObject("contractlist", contractService.getAllUserContract(userid));
		mv.setViewName("customercontractlist");
		return mv;
	}
	
	@RequestMapping("/customercontractdetail")
	public ModelAndView CustomerContractDetail(@RequestParam("contractid") String contractid, @RequestParam("userid") String userid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerid", userid);
		mv.addObject("contractdetail", contractService.getContractById(contractid));
		mv.setViewName("customercontractdetail");
		return mv;
	}
	
	@RequestMapping("/contractpunishment")
	public ModelAndView ContractPunishment(@RequestParam("contractid") String contractid, @RequestParam("userid") String userid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerid", userid);
		mv.addObject("punishmentlist", punishmentSrevice.getPunishmentByContractID(contractid));
		mv.addObject("contractid", contractid);
		mv.setViewName("contractpunishment");
		return mv;
	}
	
	@RequestMapping("/addpunishment")
	public ModelAndView AddPunishment(@RequestParam("contractid") String contractid, @RequestParam("userid") String userid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerid", userid);
		mv.addObject("contractid", contractid);
		mv.setViewName("addpunishment");
		return mv;
	}
	
	@RequestMapping("/add_punishment_function")
	public ModelAndView AddPunishmentFucntion(
			@RequestParam("userid") String userid,
			@RequestParam("contractid") String contractid,
			@RequestParam("amount") String amount,
			@RequestParam("reason") String reason,
			@RequestParam("deadline") String deadline) {
		ModelAndView mv = new ModelAndView();
		punishmentSrevice.addContractPunishment(contractid, amount, reason, deadline);
		mv.addObject("customerid", userid);
		mv.addObject("punishmentlist", punishmentSrevice.getPunishmentByContractID(contractid));
		mv.setViewName("contractpunishment");
		return mv;
	}
	
	@RequestMapping("/editpunishment")
	public ModelAndView EditPunishment(@RequestParam("punishmentid") String punishmentid, @RequestParam("contractid") String contractid, @RequestParam("userid") String userid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerid", userid);
		mv.addObject("contractid", contractid);
		mv.addObject("punishment", punishmentSrevice.getPunishmentByID(punishmentid).get(0));
		mv.setViewName("editpunishment");
		return mv;
	}
	
	@RequestMapping("/edit_punishment_function")
	public ModelAndView EditPunishmentFucntion(
			@RequestParam("userid") String userid,
			@RequestParam("contractid") String contractid,
			@RequestParam("id") String id,
			@RequestParam("amount") String amount,
			@RequestParam("reason") String reason,
			@RequestParam("deadline") String deadline) {
		ModelAndView mv = new ModelAndView();
		punishmentSrevice.editContractPunishment(id, amount, reason, deadline);
		mv.addObject("customerid", userid);
		mv.addObject("punishmentlist", punishmentSrevice.getPunishmentByContractID(contractid));
		mv.setViewName("contractpunishment");
		return mv;
	}
}
