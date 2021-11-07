package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;

@Controller
public class AdminHomeController {
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/adminhome")
	public ModelAndView HomeAdmin() {
		User user = (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("user",user);
		mv.setViewName("adminmenu");
		return mv;
	}
}
