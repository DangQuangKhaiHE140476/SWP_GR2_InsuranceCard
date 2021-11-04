package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contract;
import com.example.demo.model.Payment;
import com.example.demo.service.ContractUserService;
import com.example.demo.service.PaymentService;

@Controller
public class ManagePaymentController {
	private final PaymentService paymentService;
	private final ContractUserService contractService;
	@Autowired
	public ManagePaymentController(PaymentService paymentService,ContractUserService contractService) {
		super();
		this.paymentService = paymentService;
		this.contractService = contractService;
	}
	
	@RequestMapping("/paymenthistory")
	public ModelAndView getPayMentHistory() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Contract> contract = contractService.getContractByUserID();
		ArrayList<Payment> payment = new ArrayList<Payment>();
		for (Contract contract2 : contract) {
			payment.addAll(paymentService.getPaymentByContractID(contract2.getId().toString()));
		}
		mv.addObject("payments", payment);
		mv.setViewName("paymenthistory");
		return mv;
	}
}
