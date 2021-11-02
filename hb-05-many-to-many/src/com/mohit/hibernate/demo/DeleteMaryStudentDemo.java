package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Course;
import com.mohit.hibernate.demo.entity.Instructor;
import com.mohit.hibernate.demo.entity.InstructorDetail;
import com.mohit.hibernate.demo.entity.Review;
import com.mohit.hibernate.demo.entity.Student;

public class DeleteMaryStudentDemo {

	public static void main(String[] args) {
		
		// create a session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			// begin a transaction
			session.beginTransaction();
			
			// get the student Mary from DB
			int theStudentId = 2;
			Student tempStudent = session.get(Student.class, theStudentId);
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("\nCourses Assigned: " + tempStudent.getCourses());
			
			// delete student
			System.out.println("Deleting student...");
			session.delete(tempStudent);
			System.out.println("Student deleted");
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
