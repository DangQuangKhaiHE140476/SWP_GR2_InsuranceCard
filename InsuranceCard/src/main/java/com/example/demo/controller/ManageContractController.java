package com.example.demo.controller;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contract;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.RequestType;
import com.example.demo.model.User;
import com.example.demo.service.ContractService;
import com.example.demo.service.ContractUserService;
import com.example.demo.service.RequestService;
import com.example.demo.service.RequestStatusService;
import com.example.demo.service.RequestTypeService;
import com.example.demo.service.UserService;

@Controller
public class ManageContractController {
	private final ContractUserService service;
	private final RequestTypeService requestTypeService;
	private final RequestStatusService requestStatusService;
	private final UserService userService;
	private final RequestService requestService;
	@Autowired
	public ManageContractController(ContractUserService service,RequestTypeService requestTypeService,RequestStatusService requestStatusService,UserService userService,RequestService requestService) {
		super();
		this.service = service;
		this.requestTypeService = requestTypeService;
		this.requestStatusService = requestStatusService;
		this.userService = userService;
		this.requestService = requestService;
	}
	
	// Tuan Anh start
	@RequestMapping("/showcontractlist")
	public ModelAndView getContractByUser() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contractList",service.getContractByUserID());
		mv.setViewName("showcontractlist");
		return mv;
	}
	
	@RequestMapping("/contractuserpackage")
	public ModelAndView getContractByID(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contract", service.getContractByID(id));
		mv.setViewName("contractuserpackage");
		return mv;
	}
	
	@RequestMapping("/requestcontract")
	public ModelAndView processContract(@RequestParam("status") String status, @RequestParam("id") String id) {
		RequestStatus Status = requestStatusService.getRequestStatusByStatus("PROCESSING").get(0);
		RequestType type;
		if (status.equalsIgnoreCase("cancel")) {
			type = requestTypeService.getRequestTypeByType("CANCEL_CONTRACT").get(0);
		}else {
			type = requestTypeService.getRequestTypeByType("RENEW_CONTRACT").get(0);
		}
		User user = userService.getUser("2").get(0);
		Contract contract = service.getContractByID(id).get(0);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		
		Request request = new Request();
		request.setContract(contract);
		request.setRequestStatus(Status);
		request.setRequestType(type);
		request.setRequestdate(timestamp);
		request.setUser(user);
		requestService.addRequest(request);
		
		return new ModelAndView("redirect:/showcontractlist");
	}
	
	// End
}
