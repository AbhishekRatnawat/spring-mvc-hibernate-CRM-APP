package com.myspring.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.myspring.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName DESC", Customer.class);
		
		//execute query and get the result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		System.out.println("customers: "+ customers);
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// get the current hibernate session
		Session currenSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currenSession.get(Customer.class, theId);
		
		//now read the object from the DB
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	

}
