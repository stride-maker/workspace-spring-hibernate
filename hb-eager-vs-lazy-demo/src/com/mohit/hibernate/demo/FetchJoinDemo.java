package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mohit.hibernate.demo.entity.Course;
import com.mohit.hibernate.demo.entity.Instructor;
import com.mohit.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//**************** OPTION 2: Hibernate Qyery with HQL
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
													+ "JOIN FETCH i.courses "
													+ "where i.id=:theInstructorId", Instructor.class); 
			
			// set the parameter on the query
			query.setParameter("theInstructorId", theId);
			
			/// execute the query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Mohit: Instructor: " + tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// CLOSE THE SESSION
			session.close();
			
			System.out.println("\n\n\nSession is now closed!!!");
			
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
