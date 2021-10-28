package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PackageService;

@Controller
public class AdminShowPackageList {
	private final PackageService packageService;
	
	@Autowired
	public AdminShowPackageList(PackageService packageService) {
		this.packageService = packageService;
	}



	@RequestMapping("/showpackagelist")
	public ModelAndView ShowPackageList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("packageList", packageService.getAllPackages());
		mv.setViewName("showpackagelist");
		return mv;
	}
}
