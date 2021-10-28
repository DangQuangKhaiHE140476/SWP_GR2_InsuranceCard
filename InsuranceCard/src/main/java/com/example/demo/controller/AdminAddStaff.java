package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
public class AdminAddStaff {
	private final UserService userService;
	private final RoleService roleService;
	
	@Autowired
	public AdminAddStaff(UserService userService, RoleService roleService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@RequestMapping("/viewaddstaff")
	public String viewAddStaff() {
		return "addstaff";
	}

	@RequestMapping("/addstaff")
	public ModelAndView AddStaff(User user) {
		ArrayList<Role> list = roleService.getAllRole();
		for (Role role : list) {
			if(role.getId() == 2) {
				user.setRole(role);
				break;
			}
		}
		
		userService.addNewStaff(user);

		ModelAndView mv = new ModelAndView();
		mv.addObject("staffs", userService.viewAllStaff());
		mv.setViewName("showstafflist");
		return mv;
	}
}
