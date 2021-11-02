package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			int theStudentId = 1;
			
			// get a new session and start transaction
			session =  factory.getCurrentSession();
			session.beginTransaction();
			
			/// read the student
			System.out.println("Retrieving the student object");
			Student retrieveStudent = session.get(Student.class, theStudentId);
		    System.out.println(retrieveStudent);
					
		    System.out.println("Updating Student");
		    retrieveStudent.setFirstName("Scooby");

		    // commit the transaction
			session.getTransaction().commit();
			session.close();
			
			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for multiple statments
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
