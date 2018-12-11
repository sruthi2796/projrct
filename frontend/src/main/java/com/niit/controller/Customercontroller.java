package com.niit.controller;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Customer;
import com.niit.service.Customerservice;
@Controller
public class Customercontroller {
	@Autowired
public 	Customerservice customerservice;
	
	@RequestMapping("/registerform")
	public String Customerservice(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return"registrationpage";
		
	}
	@RequestMapping("/registercustomer")
	public String register(@ModelAttribute("customer") Customer customer,Model model){
		
		String email=customer.getUser().getEmail();
		if(!customerservice.isEmailUnique(email)){
			model.addAttribute("errorMessage","Email already exists.. please choose different email id");
			return "registrationform";
		}
		customerservice.registercustomer(customer);
		
		return "login";
	}

}
