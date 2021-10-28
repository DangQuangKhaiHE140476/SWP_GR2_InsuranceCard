package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserService;

@Controller
public class AdminDeleteStaff {
	private final UserService userService;
	
	@Autowired
	public AdminDeleteStaff(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping("/deletestaff")
	public ModelAndView deleteStaff(String id) {
		userService.deleteStaff(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs",userService.viewAllStaff());
		mv.setViewName("showstafflist");
		return mv;
	}
}
