package com.app.demo.dao;



import com.app.demo.model.*;

public interface CourseRegistration {
	Course launchCourse(Course c);
	Course cancelCourse(String courseName);
	Student registerStudent(String courseName,Student s);
	Student cancelAdmission(String email);
	Course getDetails(String courseName);

}
