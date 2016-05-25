package beans;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import rev_eng.CustomerPOJO;

public class CustomerBean {
	//props to reflect conv state of clnt
	private String email,pass;
	//for user details 
	private CustomerPOJO details;
	
	//dao
	private CustomerDao dao;

	public CustomerBean() {
		dao=new CustomerDaoImpl();
		System.out.println("bean created");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerPOJO getDetails() {
		return details;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	//B.L 
	public String validateUser() throws Exception{
		String outcome="invalid";
		details=dao.validateCustomer(email, pass);
		if(details != null)
			outcome="valid";
		return outcome;
	}

}
