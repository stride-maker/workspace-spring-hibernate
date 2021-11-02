package com.mohit.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// need a new controller method to read form data 
	// and also add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to upper case
		theName = theName.toUpperCase();
		
		// create a message
		String result = "Yo! " + theName;
		
		// add the message to model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		// convert the data to upper case
		theName = theName.toUpperCase();
		
		// create a message
		String result = "Hey my Friend from v3! " + theName;
		
		// add the message to model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}
}
