package com.mohit.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohit.springdemo.entity.Customer;
import com.mohit.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the DAO in controller
//	@Autowired
//	private CustomerDAO customerDAO; -- UPDATED WITH SERVICE INJECTION POST ADDITION OF SERVICE LAYER
	
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping(path="/list", method=RequestMethod.GET) below line replaces this line -- its a shortcut
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get the customers from the DAO -- TO SERVICE
//		List<Customer> customers = customerDAO.getCustomers(); -- UPDATED WITH SERVICE IMPL CALL
		List<Customer> customers = customerService.getCustomers();
		
		// add the customer to the DAO
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}

	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create a new model attribute to bind data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using customer service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		// get the customer from the service
		Customer customer = customerService.getCustomer(theId);
		
		// set a customer as a model attribute to prepopulate the form
		theModel.addAttribute("customer", customer);
		
		// send over the form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		// delete the customer from service
		customerService.delete(theId);
		
		return "redirect:/customer/list";
	}
}
