package com.app.demo.dao;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {
	// dependency --SF
	@Autowired
	private SessionFactory sf;
	public ContactDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("In Contact DAO"+sf);
	}
	@PostConstruct
	public void myInit() {
		System.out.println("in dao : sf " + sf);
	}

	@Override
	public Contact validateContact(String em1, String pass1) throws Exception {
		return (Contact) sf
				.getCurrentSession()
				.createQuery(
						"select c from Contact c where c.email= :em and c.password = :pass")
				.setParameter("em", em1).setParameter("pass", pass1)
				.uniqueResult();
	}

	@Override
	public Contact registerContact(Contact c) throws Exception {
		sf.getCurrentSession().persist(c);
		System.out.println("dao reted "+c);
		return c;
	}
	

}
