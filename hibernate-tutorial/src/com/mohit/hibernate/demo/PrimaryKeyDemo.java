package com.mohit.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mohit.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// create three student objects
			System.out.println("Creating three Student objects...");
			Student theStudent1 = new Student("Rohit", "Chaudhary", "mohitch.work@gmail.com");
			Student theStudent2 = new Student("Alok", "Srivastava", "alok.srivastava@gmail.com");
			Student theStudent3 = new Student("Nisha", "Dhama", "nisha.dhama@@gmail.com");

			// begin a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving the student objects");
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
