package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			// create the object mapper
			ObjectMapper mapper = new ObjectMapper(); 
			
			// read the json and convert into java pojo
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// printout the first name and last name & other stuff
			System.out.println("First Name = " + theStudent.getFirstName());
			System.out.println("Last Name = " + theStudent.getLastName());
			System.out.println("Street = " + theStudent.getAddress().getStreet());
			System.out.println("City = " + theStudent.getAddress().getCity());
			System.out.println("State = " + theStudent.getAddress().getState());
			System.out.println("Zip = " + theStudent.getAddress().getZip());
			System.out.println("Country = " + theStudent.getAddress().getCountry());
			
			for(String lang : theStudent.getLanguages()) {
				System.out.println("Language = " + lang);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
