package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	// dependency factory

	@Autowired
	private SessionFactory factory;

	// SessionFactory factory=new LocalSessionFactoryBean();

	@Override
	public Customer validateCustomer(String email, String pass) {

		return (Customer) factory
				.getCurrentSession()
				.createQuery(
						"select c from Customer c where c.email = :em and c.pass = :pass")
				.setParameter("em", email).setParameter("pass", pass)
				.uniqueResult();
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		System.out.println("in dao " + cust);
		// accept detached cust pojo & rets persistent
		factory.getCurrentSession().update(cust);
		return cust;// rets persistent
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {

		return factory.getCurrentSession().getNamedQuery("Customer.findAll")
				.list();
	}

	@Override
	public Customer getDetails(int id) {
		// TODO Auto-generated method stub
		return (Customer) factory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public String deleteCustomer(int id) {
		Customer c = getDetails(id);
		if (c != null)
			factory.getCurrentSession().delete(c);
		return "Customer "+c.getName()+"Un subcribed";
	}

	@Override
	public Customer registerCustomer(Customer c) {
		factory.getCurrentSession().save(c);
		return c;
	}
	
	

}
