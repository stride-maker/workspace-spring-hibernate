package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			int theStudentId = 3002;
			
			// get a new session and start transaction
			session =  factory.getCurrentSession();
			session.beginTransaction();
			
			/// read the student
			System.out.println("Retrieving the student object");
			Student retrieveStudent = session.get(Student.class, theStudentId);
		    System.out.println(retrieveStudent);
				
		    // delete the student
		    //session.delete(retrieveStudent);
		    
		    // delete via alternate approach
		    System.out.println("Deleting student via alternate approach");
		    session.createQuery("delete from Student where id=3001").executeUpdate();
		    
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
