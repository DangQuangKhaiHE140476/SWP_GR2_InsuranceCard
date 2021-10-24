package com.example.demo.controller;

import org.apache.el.parser.AstString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.customers;
import com.example.demo.service.customersService;

@Controller
public class customersController {
	private final customersService service;
	
	@Autowired
	public customersController(customersService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "Demo1";
	}
	
	@RequestMapping("/staff")
	public ModelAndView getAllStaff() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs",service.viewAllStaff());
		mv.setViewName("Demo1");
		return mv;
	}
	
	@RequestMapping("/staffDetails")
	public ModelAndView getStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff",service.viewStaff(id));
		mv.setViewName("Demo2");
		return mv;
	}
	
	@RequestMapping("/viewAddStaff")
		public String viewAddStaff() {
			return "AddStaff";
		}
	
	
	@RequestMapping("/addStaff")
	public ModelAndView AddStaff(customers cus) {
		service.addNewStaff(cus);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs",service.viewAllStaff());
		mv.setViewName("Demo1");
		return mv;
	}
	
	@RequestMapping("/deleteStaff")
	public ModelAndView deleteStaff(String id) {
		service.deleteStaff(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs",service.viewAllStaff());
		mv.setViewName("Demo1");
		return mv;
	}
	
	@RequestMapping("/viewUpdateStaff{id}")
	public ModelAndView viewUpdateStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff",service.viewStaff(id));
		mv.setViewName("UpdateStaff");
		return mv;
	}
	
	@RequestMapping("/updateStaff")
	public ModelAndView UpdateStaff(customers cus) {
		service.addNewStaff(cus);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff",service.viewStaff(cus.getId().toString()));
		mv.setViewName("Demo2");
		return mv;
	}
}
