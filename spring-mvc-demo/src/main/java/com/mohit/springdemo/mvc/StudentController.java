package com.mohit.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a new student object
		Student theStudent = new Student();
		
		// add student objects as a model attribute
		theModel.addAttribute("student", theStudent);
		
		
		//add the countryOptions to the model
		theModel.addAttribute("theCountryOptions", countryOptions);
	
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		System.out.println("theStudent: " + theStudent.getCountry());
		System.out.println("theStudent: " + theStudent.getFavoriteLanguage());
		
		return "student-confirmation";
	}
}
