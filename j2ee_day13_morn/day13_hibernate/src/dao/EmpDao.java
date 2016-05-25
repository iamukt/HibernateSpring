package dao;

import java.util.Date;
import java.util.List;

import one_to_one_pojos.Account;
import one_to_one_pojos.Employee;
import hib_pojos.Book;

public interface EmpDao {
	Employee addEmp(Employee e) throws Exception;
	//from emp's email --get acct details
	Account getDetails(String email) throws Exception;
	//get all employee emails for specified acct type
	List<String> getEmailsByAccountType(String acctType) throws Exception;
	//get emp details by email
	Employee getEmpDetails(String email) throws Exception;
	//delete employee
	Employee deleteEmployee(String email) throws Exception;
	
	
	

}
