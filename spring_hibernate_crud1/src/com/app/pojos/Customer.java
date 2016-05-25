package com.app.pojos;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "my_customers")
@NamedQueries(@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"))
public class Customer {

	private Integer id;
	@NotNull
	@Range(min = 100, max = 1000)
	private double depositAmt;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String name;
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[$#@%]).{5,10})")
	private String password;
	@NotNull
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date regDate;
	@NotEmpty
	private String role;

	public Customer() {
		System.out.println("in cust constr...");
		email = "Enter email here";
		id=0;
	}

	public Customer(double depositAmt, String email, String name,
			String passwordword, Date regDate, String role) {
		super();

		this.depositAmt = depositAmt;
		this.email = email;
		this.name = name;
		this.password = passwordword;
		this.regDate = regDate;
		this.role = role;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "deposit_amt", columnDefinition = "decimal(6,1)")
	public double getDepositAmt() {
		return this.depositAmt;
	}

	public void setDepositAmt(double depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
	//	System.out.println("in set email");
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "reg_date")
	@Temporal(TemporalType.DATE)
	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", depositAmt=" + depositAmt + ", email="
				+ email + ", name=" + name + ", passwordword=" + password
				+ ", regDate=" + regDate + ", role=" + role + "]";
	}

}