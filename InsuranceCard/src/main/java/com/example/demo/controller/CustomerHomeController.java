package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;

@Controller
public class CustomerHomeController {
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/customermenu")
	public ModelAndView HomeCustomer() {
		User user = (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("user",user);
		mv.setViewName("customermenu");
		return mv;
	}
}
