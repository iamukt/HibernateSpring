package com.app.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "dac_courses")
public class Course implements Serializable {
	private Integer id;
	private String name;
	private Date beginDate, endDate;
	private double fees;
	private Set<Student> students = new HashSet<>();

	public Course() {
		System.out.println("in course constr");
	}

	public Course(String name, Date beginDate, Date endDate, double fees,
			Set<Student> students) {
		super();
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.fees = fees;
		this.students = students;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "begin_date")
	@Temporal(TemporalType.DATE)
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(columnDefinition = "decimal(8,1)")
	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	// , fetch = FetchType.EAGER -- not recommended.
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	// for mapping rev asso between 2 entities & to avoid creation of extra join
	// table -- use mappedBy attribute
	// mappedBy -- name of property specifying asso -- as it appears in asso
	// entity
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course id=" + id + ", name=" + name + ", beginDate="
				+ beginDate + ", endDate=" + endDate + ", fees=" + fees
				+ "\n students reged :" + students;

	}

	// helper methods @ POJO level : typicall to be used in any---many
	public boolean addStudent(Student s) {
		if (students.add(s)) { // MAP reverse association : iff student is
								// successfully added to d set
			s.setCourse(this);
			return true;
		}
		return false;
	}

	public void removeStudent(Student s) {
		students.remove(s);
	}

}
