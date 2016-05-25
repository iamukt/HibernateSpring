package com.app.demo.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="dac_students")
public class Student implements Serializable {
	private Integer id;
	private String name,email;
	private String addr;
	private Course course;
	public Student() {
		System.out.println("in stud constr");
	}
	public Student(String name, String addr, Course course) {
		super();
		this.name = name;
		this.addr = addr;
		this.course = course;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=10)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=10)
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@ManyToOne
	@JoinColumn(name="course_id",nullable=false)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Column(length=10,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student id=" + id + ", name=" + name + ", addr=" + addr
				+ ", registered for course " + course.getName();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	

}
