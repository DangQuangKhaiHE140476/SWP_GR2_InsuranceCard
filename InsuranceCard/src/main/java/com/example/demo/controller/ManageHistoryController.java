package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Accident;
import com.example.demo.model.Contract;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.RequestType;
import com.example.demo.model.User;
import com.example.demo.service.AccidentService;
import com.example.demo.service.ContractUserService;
import com.example.demo.service.RequestService;
import com.example.demo.service.RequestStatusService;
import com.example.demo.service.RequestTypeService;

@Controller
public class ManageHistoryController {
	private final AccidentService accidentService;
	private final ContractUserService contractService;
	private final RequestTypeService requestTypeService;
	private final RequestStatusService requestStatusService;
	private final RequestService requestService;
	@Autowired
	public ManageHistoryController(AccidentService accidentService, ContractUserService contractService, RequestTypeService requestTypeService, RequestStatusService requestStatusService, RequestService requestService) {
		super();
		this.accidentService = accidentService;
		this.contractService = contractService;
		this.requestTypeService = requestTypeService;
		this.requestStatusService = requestStatusService;
		this.requestService = requestService;
	}
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/accidenthistory")
	public ModelAndView getAccidentByUser() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<Contract> contract = contractService.getContractByCurrentUserID();
		ArrayList<Accident> accident = new ArrayList<Accident>();
		
		for (Contract contract2 : contract) {
			accident.addAll(accidentService.getAccidentByContractID(contract2.getId().toString()));
		}
		
		mv.addObject("accidents", accident);
		mv.setViewName("accidenthistory");
		return mv;
	}
	
//	@RequestMapping("/compensationhistory")
//	public ModelAndView getCompensationByAccident() {
//		ModelAndView mv = new ModelAndView();
//		
//		ArrayList<Contract> contract = contractService.getContractByCurrentUserID();
//		ArrayList<Accident> accident = new ArrayList<Accident>();
//		
//		for (Contract contract2 : contract) {
//			accident.addAll(accidentService.getAccidentByContractID(contract2.getId().toString()));
//		}
//		
//		mv.addObject("accidents", accident);
//		mv.setViewName("compensationhistory");
//		return mv;
//		
//	}
	
	@RequestMapping("/requestcompensation")
	public ModelAndView requestCompensation(@RequestParam("id")String id) {
		RequestStatus Status = requestStatusService.getRequestStatusByStatus("PROCESSING").get(0);
		RequestType type;
		
		type = requestTypeService.getRequestTypeByType("REQUEST_COMPENSATION").get(0);

		User user = (User) session.getAttribute("user");
		Contract contract = contractService.getContractByID(id).get(0);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		
		Request request = new Request();
		request.setContract(contract);
		request.setRequestStatus(Status);
		request.setRequestType(type);
		request.setRequestdate(timestamp);
		request.setUser(user);
		requestService.addRequest(request);
		
		return new ModelAndView("redirect:/compensationhistory");
	}
	
	@RequestMapping("/compensationhistory")
	public ModelAndView getCompensationByAccident() {
		ModelAndView mv = new ModelAndView();
		
		User user = (User) session.getAttribute("user");
		
		List<Accident> accidents = new ArrayList<>();
		
		for(Contract contract : user.getContracts()) {
			for(Accident accident : contract.getAccidents()) {
				accidents.add(accident);
			}
		}
		
		mv.addObject("accidents", accidents);
		mv.setViewName("compensationhistory");
		return mv;
		
	}
}
