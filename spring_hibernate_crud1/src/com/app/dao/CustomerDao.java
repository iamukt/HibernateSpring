package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;

public interface CustomerDao {
	Customer validateCustomer(String email,String pass);
	Customer updateCustomer(Customer cust);
	List<Customer>listCustomers();
	Customer getDetails(int id);
	String deleteCustomer(int id);
	Customer registerCustomer(Customer c);


}
