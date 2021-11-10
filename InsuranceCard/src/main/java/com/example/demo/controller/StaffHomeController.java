package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;

@Controller
public class StaffHomeController {
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/staffmenu")
	public ModelAndView HomeStaff() {
		User user = (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("user",user);
		mv.setViewName("staffmenu");
		return mv;
	}
}
