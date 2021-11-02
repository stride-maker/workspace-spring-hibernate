package com.mohit.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
		
		System.out.println("Customer last name: |" + theCustomer.getLastName() + "|");
		System.out.println("\n\n theBindingResult: " + theBindingResult);
		System.out.println("\n\n\n");
		
		return theBindingResult.hasErrors() ? "customer-form" : "customer-confirmation";
	}
	
	// add the initbinder - to trim the input strings
	// remove leading and trailing whitespaces
	// resolve issue of our whitespaces
	
	@InitBinder
	public void initBinder(WebDataBinder theBinder) {
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		
		theBinder.registerCustomEditor(String.class, editor);
	}
}
