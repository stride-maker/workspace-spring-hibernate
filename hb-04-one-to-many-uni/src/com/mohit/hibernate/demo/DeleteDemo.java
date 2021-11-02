package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Instructor;
import com.mohit.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create a session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			// begin a transaction
			session.beginTransaction();
			
			// get the instructor by primary key
			int theId = 1;
			Instructor theInstructor = session.get(Instructor.class, theId);
			System.out.println("Found Instructor: " + theInstructor);
			
			// delete the instructor
			if(theInstructor != null) {
				System.out.println("About to delete the instructor: " + theInstructor);
				
				// this will also the instructor details
				// because CascadeType.ALL
				session.delete(theInstructor);
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
