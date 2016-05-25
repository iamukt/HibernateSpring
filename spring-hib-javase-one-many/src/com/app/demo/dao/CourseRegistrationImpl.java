package com.app.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.demo.model.*;

@Repository
public class CourseRegistrationImpl implements CourseRegistration {
	@Autowired
	private SessionFactory factory;

	@Override
	public Course launchCourse(Course c) {
		factory.getCurrentSession().persist(c);
		System.out.println("in dao " + c);
		return c;// persistent
	}

	@Override
	public Course cancelCourse(String nm) {
		Course c = getDetails(nm);// one dao layer method calling another dao
									// layer method
		if (c != null)
			factory.getCurrentSession().delete(c);
		return c;
	}

	@Override
	public Student registerStudent(String courseName, Student s) {

		Session sess = factory.getCurrentSession();
		Course c1 = (Course) sess
				.createQuery("select c from Course c where c.name = :nm")
				.setParameter("nm", courseName).uniqueResult();
		if (c1 != null && c1.addStudent(s)) {
			System.out.println("in dao " + s);
			return s;
		}
		return null;

	}

	@Override
	public Student cancelAdmission(String email) {

		Session sess = factory.getCurrentSession();
		Student s = (Student) sess.createQuery("from Student where email=:em")
				.setParameter("em", email).uniqueResult();
		if (s != null)
			sess.delete(s);// if student by email is found then delete it.
		return s;

	}

	@Override
	public Course getDetails(String courseName) {
		Session sess = factory.getCurrentSession();
		Course c1 = (Course) sess
				.createQuery("select c from Course c where c.name = :nm")
				.setParameter("nm", courseName).uniqueResult();
		return c1;
	}

}
