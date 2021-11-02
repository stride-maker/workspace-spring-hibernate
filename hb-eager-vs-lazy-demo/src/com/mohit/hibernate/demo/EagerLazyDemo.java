package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Course;
import com.mohit.hibernate.demo.entity.Instructor;
import com.mohit.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		// create a session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// begin a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Mohit: Instructor: " + tempInstructor);
			System.out.println("Mohit: Courses: " + tempInstructor.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();
			
			// CLOSE THE SESSION
			session.close();
			
			System.out.println("\n\n\nSession is now closed!!!");
			//**************** OPTION 1:  call the getter method while the session is still open - this will work
			
			// since the courses are lazy loaded ... this should fail the fetching courses
			
			// retrieve the courses
			System.out.println("Mohit: Courses: " + tempInstructor.getCourses());
						
			
			System.out.println("Mohit: Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
