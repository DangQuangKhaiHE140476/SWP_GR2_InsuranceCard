package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {

	@RequestMapping("/adminhome")
	public String HomeAdmin() {
		return "adminmenu";
	}
}
