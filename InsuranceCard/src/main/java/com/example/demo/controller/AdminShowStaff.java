package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserService;

@Controller
public class AdminShowStaff {
	private final UserService userService;
	
	@Autowired
	public AdminShowStaff(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping("/showstaffdetail")
	public ModelAndView getStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff", userService.viewStaff(id));
		mv.setViewName("showstaffdetail");
		return mv;
	}
}
