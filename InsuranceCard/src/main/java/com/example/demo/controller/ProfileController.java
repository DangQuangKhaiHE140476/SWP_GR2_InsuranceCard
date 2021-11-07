package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class ProfileController {
	@Autowired
	private HttpSession session;
	
	private final UserService userService;
	
	@Autowired
	public ProfileController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/viewprofile")
	public ModelAndView viewProfile() {
		User user = (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		User updatedUser = userService.getUserByUsername(user.getUsername());
		mv.addObject("user",updatedUser);
		mv.setViewName("viewprofile");
		return mv;
	}
	
	@RequestMapping("/vieweditprofile")
	public ModelAndView viewEditProfile() {
		User user = (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",user);
		mv.setViewName("vieweditprofile");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateprofile")
	public ModelAndView updateProfile(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("socialsercuritynumber") String ssn,
			@RequestParam("dob") String dob,
			@RequestParam("gender") String gender,
			@RequestParam("address") String address,
			@RequestParam("phonenumber") String phonenumber,
			@RequestParam("email") String email) {
		
		ModelAndView mv = new ModelAndView();
		userService.updateUserProfile(id, name, ssn, dob, gender, address, phonenumber, email);
		mv.setViewName("redirect:/viewprofile");
		return mv;
	}
}
