package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerRepo;
	
	@GetMapping("/show/all") // localhost:8080/customer/show/all
	public String getCustomerList(Model model) {
		try {
			model.addAttribute("customers", customerRepo.selectAllCustomers());
			return "customer-all-page";
		}catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "error-page";
		}
	}
}
