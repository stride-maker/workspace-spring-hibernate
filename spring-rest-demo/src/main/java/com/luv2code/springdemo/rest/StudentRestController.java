package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<Student>();

		theStudents.add(new Student("Mohit", "Chaudhary"));
		theStudents.add(new Student("Nisha", "Dhama"));
		theStudents.add(new Student("Yashpal", "Singh"));
	}
	
	@GetMapping("/students")
	public List<Student> listOfStudents() {
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId against the list size
		if((studentId >= theStudents.size()) || (studentId <0)) {
			throw new StudentNotFoundException("Student not found with id - " + studentId);
		}
	
		return theStudents.get(studentId);
	}
	
}
