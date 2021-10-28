package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
public class AdminEditStaff {
	private final UserService userService;
	private final RoleService roleService;
	
	@Autowired
	public AdminEditStaff(UserService userService, RoleService roleService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@RequestMapping("/viewUpdateStaff{id}")
	public ModelAndView viewUpdateStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff",userService.viewStaff(id));
		mv.setViewName("updatedtaff");
		return mv;
	}
	
	@RequestMapping("/updateStaff")
	public ModelAndView UpdateStaff(User user) {
		ArrayList<Role> list = roleService.getAllRole();
		for (Role role : list) {
			if(role.getId() == 2) {
				user.setRole(role);
				break;
			}
		}
		
		//write code for update in repo and use it .-.
		userService.addNewStaff(user);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("staff",userService.viewStaff(user.getId().toString()));
		mv.setViewName("showstaffdetail");
		return mv;
	}
}
