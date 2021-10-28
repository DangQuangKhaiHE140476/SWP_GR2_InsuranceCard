package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PackageService;

@Controller
public class AdminShowPackage {
	private final PackageService packageService;
	
	@Autowired
	public AdminShowPackage(PackageService packageService) {
		this.packageService = packageService;
	}
	@RequestMapping("/showpackage{id}")
	public ModelAndView ShowPackage(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("package", packageService.getPackageById(id));
		mv.setViewName("showpackage");
		return mv;
	}
}
