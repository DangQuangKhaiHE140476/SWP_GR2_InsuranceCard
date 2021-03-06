package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
public class ManageStaffController {
	private final UserService userService;
	private final RoleService roleService;
	@Autowired
	private HttpSession session;
	@Autowired
	public ManageStaffController(UserService userService, RoleService roleService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
	}

	@RequestMapping("/showstafflist")
	public ModelAndView getAllStaff() {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		mv.addObject("user",user);
		mv.addObject("staffs", userService.viewAllStaff());
		mv.setViewName("showstafflist");
		return mv;
	}
	
	@RequestMapping("/showstaffdetail")
	public ModelAndView getStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		mv.addObject("user",user);
		mv.addObject("staff", userService.viewStaff(id));
		mv.setViewName("showstaffdetail");
		return mv;
	}
	
	@RequestMapping("/viewaddstaff")
	public ModelAndView viewAddStaff() {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		mv.addObject("user",user);
		mv.setViewName("addstaff");
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST,value = "/addstaff")
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
		User user1 = (User) session.getAttribute("user");
		mv.addObject("user",user1);
		mv.addObject("staffs", userService.viewAllStaff());
		mv.setViewName("showstafflist");
		return mv;
	}
	
	@RequestMapping("/viewUpdateStaff{id}")
	public ModelAndView viewUpdateStaff(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		mv.addObject("user",user);
		mv.addObject("staff",userService.viewStaff(id));
		mv.setViewName("updatestaff");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/updateStaff")
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
		User user1 = (User) session.getAttribute("user");
		mv.addObject("user",user1);
		
		mv.addObject("staff",userService.viewStaff(user.getId().toString()));
		mv.setViewName("showstaffdetail");
		return mv;
	}
	
	@RequestMapping("/deleteStaff{id}")
	public ModelAndView deleteStaff(@RequestParam("id") String id) {
		userService.deleteStaff(id);
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		mv.addObject("user",user);
		mv.addObject("staffs",userService.viewAllStaff());
		mv.setViewName("showstafflist");
		return mv;
	}
}
