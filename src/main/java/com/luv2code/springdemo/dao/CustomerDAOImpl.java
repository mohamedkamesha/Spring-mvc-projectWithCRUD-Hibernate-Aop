package com.luv2code.springdemo.dao;

import java.util.List;

 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 

import com.luv2code.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//get session
		Session session = sessionFactory.getCurrentSession();
		//order by lastName
		Query<Customer> query = session.createQuery("from Customer order by lastName ",Customer.class);
		List<Customer> customers = query.getResultList();
		
		//in one row
		//List<Customer> customers = session.createQuery("from Customer",Customer.class).getResultList();
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		//get session
		Session session = sessionFactory.getCurrentSession();
		
		// save 
		session.saveOrUpdate(customer);
		
		
	}

	@Override
	public Customer getCustomer(int id) {
		//get session
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		//get session
		Session session = sessionFactory.getCurrentSession();
		//delete by query
		Query query = session.createQuery("delete from Customer where id=:id ");
		
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
