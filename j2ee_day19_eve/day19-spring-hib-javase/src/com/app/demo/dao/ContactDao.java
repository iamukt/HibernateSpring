package com.app.demo.dao;

import com.app.demo.model.Contact;

public interface ContactDao {
	Contact validateContact(String em,String pass) throws Exception;
	Contact registerContact(Contact c) throws Exception;

}
