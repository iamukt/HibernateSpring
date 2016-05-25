package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.pojos.Customer;

@Service("dao_based_service")
// mandatory
@Transactional
// mandatory
public class CustomerServiceDaoBasedImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	@Override
	@Transactional(readOnly = true)
	public Customer validateCustomer(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.validateCustomer(email, pass);
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		Customer c = dao.updateCustomer(cust);// c --- PERSISTENT
		// c.setDepositAmt(c.getDepositAmt() + 100);// uncomment to confirm
		// persistent state in service method
		return c;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Customer> listCustomers() {
		List<Customer> l1=dao.listCustomers();
		return l1;
	}


	@Override
	@Transactional(readOnly=true)
	public Customer getDetails(int id) {
		Customer c=dao.getDetails(id);
		System.out.println("in service : getDetails "+c);
		return c;
	}

	@Override
	public String deleteCustomer(int id) {
		
		return dao.deleteCustomer(id);
	}

	@Override
	public Customer registerCustomer(Customer c) {
		// TODO Auto-generated method stub
		return dao.registerCustomer(c);
	}
	
	
	



}
