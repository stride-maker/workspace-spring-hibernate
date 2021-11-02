package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create  a student object
			System.out.println("Creating a new Student object...");
			Student theStudent = new Student("Paul", "Wall", "paul.wall@mohit.com");
			
			// begin a transaction
			session.beginTransaction();
			
			// save the object 
			System.out.println("Saving the student object");
			System.out.println(theStudent);
			session.save(theStudent);
			session.close();
			
			// read the object
			System.out.println("Saved Student. Generated Id: " + theStudent.getId());
			
			// get a new session and start transaction
			session =  factory.getCurrentSession();
			session.beginTransaction();
			
			/// read the student
			System.out.println("Retrieving the student object");
			Student retrieveStudent = session.get(Student.class, theStudent.getId());
		    System.out.println(retrieveStudent);
					
			// commit the transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
