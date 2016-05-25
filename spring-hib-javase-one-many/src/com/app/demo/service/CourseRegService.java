package com.app.demo.service;

import java.util.Set;

import com.app.demo.model.*;

public interface CourseRegService {
	Course launchCourse(Course c);
	Course cancelCourse(String courseName);
	Student registerStudent(String courseName,Student s);
	Student cancelAdmission(String email);
	Course getDetails(String courseName);
}
