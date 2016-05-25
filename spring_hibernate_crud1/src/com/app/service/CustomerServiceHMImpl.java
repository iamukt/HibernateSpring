package com.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.pojos.Customer;

@Service("hm_service")
public class CustomerServiceHMImpl implements CustomerService {
	private HashMap<String, Customer> customers;

	public CustomerServiceHMImpl() {
		customers = new HashMap<String, Customer>();
		customers.put("a@gmail", new Customer(500, "a@gmail", "a", "abc123#",
				new Date(), "cust"));
		System.out.println("in constr of " + getClass().getName());
	}

	@Override
	public Customer validateCustomer(String email, String pass) {
		Customer c = null;
		if (customers.containsKey(email)) {
			c = customers.get(email);
			if (!c.getPassword().equals(pass))
				c = null;
			else
				System.out.println("service "+c);
		}
		return c;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> listCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer registerCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
