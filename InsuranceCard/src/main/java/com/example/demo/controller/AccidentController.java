package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Accident;
import com.example.demo.service.AccidentService;

@Controller
public class AccidentController {
	private final AccidentService accidentService;
	
	@Autowired
	public AccidentController(AccidentService accidentService) {
		this.accidentService = accidentService;
	}

	@RequestMapping("/reportaccident")
	public ModelAndView requestAccident() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reportaccident");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/report")
	public ModelAndView addRequestAccident(Accident accident) {
		accidentService.addAccident(accident);
		return new ModelAndView("redirect:/accidenthistory");
	}
}
