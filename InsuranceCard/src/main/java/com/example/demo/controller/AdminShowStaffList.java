package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserService;

@Controller
public class AdminShowStaffList {
	private final UserService userService;
	
	@Autowired
	public AdminShowStaffList(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping("/showstafflist")
	public ModelAndView getAllStaff() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs", userService.viewAllStaff());
		mv.setViewName("showstafflist");
		return mv;
	}
}
