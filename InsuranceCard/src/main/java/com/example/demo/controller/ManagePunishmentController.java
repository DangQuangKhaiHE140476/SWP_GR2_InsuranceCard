package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contract;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentType;
import com.example.demo.model.Punishment;
import com.example.demo.model.PunishmentStatus;
import com.example.demo.service.ContractUserService;
import com.example.demo.service.PaymentService;
import com.example.demo.service.PaymentTypeService;
import com.example.demo.service.PunishmentService;
import com.example.demo.service.PunishmentStatusService;
@Controller
public class ManagePunishmentController {
	private final ContractUserService contractService;
	private final PunishmentService punishmentService;
	private final PaymentTypeService paymentTypeService;
	private final PaymentService paymentService;
	private final PunishmentStatusService punishmentStatusService;
	@Autowired
	public ManagePunishmentController(ContractUserService contractService, PunishmentService punishmentService, PaymentTypeService paymentTypeService, PaymentService paymentService, PunishmentStatusService punishmentStatusService) {
		super();
		this.contractService = contractService;
		this.punishmentService = punishmentService;
		this.paymentTypeService = paymentTypeService;
		this.paymentService = paymentService;
		this.punishmentStatusService = punishmentStatusService;
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
	
	@RequestMapping("/payfine")
	public ModelAndView processPayFine(@RequestParam("punishid")String punishid, @RequestParam("id")String id) {
		ModelAndView mv = new ModelAndView();
		Payment p = new Payment();
		p.setContract(contractService.getContractByID(id).get(0));
		p.setPunishment(punishmentService.getPunishmentByID(punishid).get(0));
		p.setPaymentType(paymentTypeService.getPaymentType("PUNISHMENT").get(0));
		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		p.setPaymentdate(timestamp);
		
		paymentService.addPayment(p);
		
		Punishment punishment = punishmentService.getPunishmentByID(punishid).get(0);
		punishment.setPunishmentStatus(punishmentStatusService.getPaymentStatusPaid("PAID").get(0));
		punishmentService.addPunishment(punishment);
		
		return new ModelAndView("redirect:/punishmenthistory");
	}
}
