package dao;

import rev_eng.CustomerPOJO;

public interface CustomerDao {
	CustomerPOJO validateCustomer(String em, String pass) throws Exception;

}
