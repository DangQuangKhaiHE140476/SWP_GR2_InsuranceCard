package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contract;
import com.example.demo.model.Package;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.RequestType;
import com.example.demo.model.User;
import com.example.demo.service.ContractStatusService;
import com.example.demo.service.ContractUserService;
import com.example.demo.service.RequestService;
import com.example.demo.service.RequestStatusService;
import com.example.demo.service.RequestTypeService;

@Controller
public class ManageRequestController {
	private final RequestService requestService;
	private final ContractUserService contractService;
	private final ContractStatusService contractStatusService;
	private final RequestStatusService requestStatusService;
	private final RequestTypeService requestTypeService;
	@Autowired
	public ManageRequestController(RequestService requestService,ContractUserService contractService,ContractStatusService contractStatusService,RequestStatusService requestStatusService,RequestTypeService requestTypeService) {
		super();
		this.requestService = requestService;
		this.contractService = contractService;
		this.contractStatusService = contractStatusService;
		this.requestStatusService = requestStatusService;
		this.requestTypeService = requestTypeService;
	}
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/requestmenu")
	public ModelAndView requestMenu() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("showrequestlist");
		return mv;
	}
	
	@RequestMapping("/requestcancel")
	public ModelAndView requestCancel() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("cancels",requestService.getRequestByTypeID("3"));
		mv.setViewName("requestcancel");
		return mv;
	}
	
	@RequestMapping("/requestrenew")
	public ModelAndView requestRenew() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("renews",requestService.getRequestByTypeID("2"));
		mv.setViewName("requestrenew");
		return mv;
	}
	
	@RequestMapping("/requestnew")
	public ModelAndView requestNew() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Contract> list = contractService.getContractProcess();
		
//		for (Contract c : list) {
//			User user = (User) session.getAttribute("user");
//			//Contract contract = contractService.getContractByID(c.getId().toString()).get(0);
//			Date date = new Date();
//			Timestamp timestamp = new Timestamp(date.getTime());
//			RequestStatus Status = requestStatusService.getRequestStatusByStatus("PROCESSING").get(0);
//			RequestType type = requestTypeService.getRequestTypeByType("NEW_CONTRACT").get(0);
//			
//			Request request = new Request();
//			request.setContract(c);
//			request.setRequestStatus(Status);
//			request.setRequestType(type);
//			request.setRequestdate(timestamp);
//			request.setUser(user);
//			requestService.addRequest(request);
//		}
		
		mv.addObject("news",requestService.getRequestByTypeID("1"));
		mv.setViewName("requestnew");
		return mv;
	}	
	
	@RequestMapping("/resolveRequest")
	public ModelAndView resolveRequest(@RequestParam("status") String status,@RequestParam("id") String id,@RequestParam("requestid") String requestid) {
		
		ModelAndView mv = new ModelAndView();
		Contract c = contractService.getContractByID(id).get(0);
		String redirect = "";
		
		if(status.equals("cancel")) {			
			c.setContractStatus(contractStatusService.getContractStatusByID("3"));
			 redirect = "redirect:/requestcancel";
		}else if(status.equals("renew")){			
			String duration = c.getPackage_().getDuration();
			String[] a = duration.split(" ");
			int newDuration = Integer.parseInt(a[0]) + 1;
			
			Package p = c.getPackage_();
			p.setDuration(String.valueOf(newDuration) + " year");
			c.setPackage_(p);
			redirect = "redirect:/requestrenew";
		}else {
			c.setContractStatus(contractStatusService.getContractStatusByID("2"));
			redirect = "redirect:/requestnew";
		}
		contractService.saveContract(c);
		
		Request r = requestService.getById(requestid).get();
		r.setRequestStatus(requestStatusService.getRequestStatusByStatus("RESOLVED").get(0));
		requestService.addRequest(r);

		return new ModelAndView(redirect);
	}
}
