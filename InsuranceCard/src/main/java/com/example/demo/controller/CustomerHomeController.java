package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerHomeController {
	@RequestMapping("/customermenu")
	public String HomeAdmin() {
		return "customermenu";
	}
}
