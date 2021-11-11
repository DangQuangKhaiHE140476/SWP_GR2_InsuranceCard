package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.CompensationService;

@Controller
public class CompensationController {
	private final CompensationService compensationService;
	
	@Autowired
	public CompensationController(CompensationService compensationService) {
		this.compensationService = compensationService;
	}


	@RequestMapping("/compensationlist")
	public ModelAndView compensationList() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("compensationlist", compensationService.getAllCompensation());
		mv.setViewName("compensationlist");
		return mv;
	}
	
	@RequestMapping("/compensationdetail")
	public ModelAndView compensationDetail(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("compensation", compensationService.getCompensationByID(id).get(0));
		mv.setViewName("compensationdetail");
		return mv;
	}

	@RequestMapping("/resolvecompensation")
	public ModelAndView resolveCompensation(@RequestParam("id") String id) {
		compensationService.resolveCompensation(id);
		return new ModelAndView("redirect:/compensationdetail?id="+id);
	}
}
