package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	private final UserService service;
	private final RoleService service1;
	
	@Autowired
	public UserController(UserService service, RoleService service1) {
		super();
		this.service = service;
		this.service1 = service1;
	}

	@RequestMapping("/staff")
	public ModelAndView getAllStaff() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs", service.viewAllStaff());
		mv.setViewName("ShowStaffList");
		return mv;
	}

	@RequestMapping("/staffDetails")
	public ModelAndView getStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff", service.viewStaff(id));
		mv.setViewName("ShowStaffDetails");
		return mv;
	}

	@RequestMapping("/viewAddStaff")
	public String viewAddStaff() {
		return "AddStaff";
	}

	@RequestMapping("/addStaff")
	public ModelAndView AddStaff(User user) {
		ArrayList<Role> list = service1.getAllRole();
		for (Role role : list) {
			if(role.getId() == 2) {
				user.setRole(role);
				break;
			}
		}
		
		service.addNewStaff(user);

		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs", service.viewAllStaff());
		mv.setViewName("ShowStaffList");
		return mv;
	}
	
	@RequestMapping("/deleteStaff")
	public ModelAndView deleteStaff(String id) {
		service.deleteStaff(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs",service.viewAllStaff());
		mv.setViewName("ShowStaffList");
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
	public ModelAndView UpdateStaff(User user) {
		ArrayList<Role> list = service1.getAllRole();
		for (Role role : list) {
			if(role.getId() == 2) {
				user.setRole(role);
				break;
			}
		}
		service.addNewStaff(user);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff",service.viewStaff(user.getId().toString()));
		mv.setViewName("ShowStaffDetails");
		return mv;
	}
}
