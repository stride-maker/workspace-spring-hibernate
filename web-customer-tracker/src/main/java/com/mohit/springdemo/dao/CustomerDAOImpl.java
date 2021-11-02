package com.mohit.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mohit.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional -- MOVED TO SERVICE LAYER 
	public List<Customer> getCustomers() {
		
		// get the current session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name 
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		// get the results from query
		List<Customer> listOfCustomers = query.getResultList();
		
		// return the list of customers retrieved
		return listOfCustomers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
//		currentSession.save(theCustomer);
		
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the customer from database
		Customer customer = currentSession.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void delete(int theId) {
		
		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete the customer
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", theId);
		query.executeUpdate();
	}
	
}
