package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contract;
import com.example.demo.model.Package;
import com.example.demo.model.Request;
import com.example.demo.service.ContractStatusService;
import com.example.demo.service.ContractUserService;
import com.example.demo.service.RequestService;
import com.example.demo.service.RequestStatusService;

@Controller
public class ManageRequestController {
	private final RequestService requestService;
	private final ContractUserService contractService;
	private final ContractStatusService contractStatusService;
	private final RequestStatusService requestStatusService;
	@Autowired
	public ManageRequestController(RequestService requestService,ContractUserService contractService,ContractStatusService contractStatusService,RequestStatusService requestStatusService) {
		super();
		this.requestService = requestService;
		this.contractService = contractService;
		this.contractStatusService = contractStatusService;
		this.requestStatusService = requestStatusService;
	}
	
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
			p.setDuration(String.valueOf(newDuration));
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
