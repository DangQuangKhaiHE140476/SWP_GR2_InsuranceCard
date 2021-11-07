package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.ContractService;
import com.example.demo.service.PackageService;

@Controller
public class ManageContractPackageController {

	private final PackageService packageService;
    private final ContractService contractService;
	
	@Autowired
	private HttpSession session;
    
    @Autowired
	public ManageContractPackageController(PackageService packageService,
			ContractService contractService) {
		super();
		this.packageService = packageService;
		this.contractService = contractService;
	}

	@RequestMapping("/contractpackagelist")
	public ModelAndView ContractPackageList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", session.getAttribute("user"));
		mv.addObject("packageList", packageService.getAllPackages());
		mv.setViewName("contractpackagelist");
		return mv;
	}
	
	@RequestMapping("/contractpackage{id}")
	public ModelAndView ContractPackage(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", session.getAttribute("user"));
		mv.addObject("package", packageService.getPackageById(id));
		mv.setViewName("contractpackage");
		return mv;
	}
	
	@RequestMapping("/requestnewcontract{id}")
	public ModelAndView RequestNewContract(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		User u = (User) session.getAttribute("user");
		mv.addObject("user", u);
		mv.addObject("currentdate", contractService.getCurrentDate().toString());
		mv.addObject("package", packageService.getPackageById(id));
		mv.setViewName("requestnewcontract");
		return mv;
	}
	
	@RequestMapping("/checkout")
	public ModelAndView Checkout(
			@RequestParam("userid") String userid,
			@RequestParam("ownername") String ownername,
			@RequestParam("vehicletype") String vehicletype,
			@RequestParam("brand") String brand,
			@RequestParam("model") String model,
			@RequestParam("color") String color,
			@RequestParam("registerdate") String registerdate,
			@RequestParam("chassisnumber") String chassisnumber,
			@RequestParam("licienseplate") String licienseplate,
			@RequestParam("packageid") String packageid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("userid",userid);
		mv.addObject("ownername",ownername);
		mv.addObject("vehicletype",vehicletype);
		mv.addObject("brand",brand);
		mv.addObject("model",model);
		mv.addObject("color",color);
		mv.addObject("registerdate",registerdate);
		mv.addObject("chassisnumber",chassisnumber);
		mv.addObject("licienseplate",licienseplate);
		mv.addObject("packageid",packageid);
		mv.addObject("currentdate", contractService.getCurrentDate().toString());
		mv.addObject("TotalAmount", packageService.getPackageById(packageid).getPrice());
		mv.setViewName("checkout");
		return mv;
	}
	
	@RequestMapping("/request")
	public String Request(
			@RequestParam("userid") String userid,
			@RequestParam("ownername") String ownername,
			@RequestParam("vehicletype") String vehicletype,
			@RequestParam("brand") String brand,
			@RequestParam("model") String model,
			@RequestParam("color") String color,
			@RequestParam("registerdate") String registerdate,
			@RequestParam("chassisnumber") String chassisnumber,
			@RequestParam("licienseplate") String licienseplate,
			@RequestParam("packageid") String packageid){
		contractService.RequestNewContract(userid, ownername, vehicletype, brand, model, color, registerdate, chassisnumber, licienseplate, packageid);
		return "redirect:/contractpackagelist";
	}
}
