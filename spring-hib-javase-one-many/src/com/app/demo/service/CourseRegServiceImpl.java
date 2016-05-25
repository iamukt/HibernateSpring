package com.app.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.dao.CourseRegistration;
import com.app.demo.model.*;

@Service
@Transactional
public class CourseRegServiceImpl implements CourseRegService {
	@Autowired
	private CourseRegistration dao;

	@Transactional(isolation = Isolation.SERIALIZABLE,timeout=5)
	@Override
	public Course launchCourse(Course c) {
		c = dao.launchCourse(c);
		// c ---persistent
		System.out.println("in service adding sleep" + c);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in service after sleep" + c);
		return c;
	}

	@Override
	public Course cancelCourse(String courseName) {
		Course c1 = dao.cancelCourse(courseName);
		if (c1 != null)
			c1.getStudents().size();
		return c1;

	}

	@Override
	public Student registerStudent(String courseName, Student s) {
		
			Student s1 = dao.registerStudent(courseName, s);
			System.out.println("in ser "+s1);
			return s1;
	}

	@Override
	public Student cancelAdmission(String email) {
		return dao.cancelAdmission(email);
	}

	@Override
	public Course getDetails(String courseName) {
		Course c = dao.getDetails(courseName);
		if (c != null)
			System.out.println("fm service " + c.getStudents());
		return c;
	}
}
