package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;

@Controller
public class HistoryHomeController {

	@RequestMapping("/historymenu")
	public ModelAndView HomeCustomer() {
		
		ModelAndView mv = new ModelAndView();

		mv.setViewName("historymenu");
		return mv;
	}
}
