package one_to_one_pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "dac_emp1", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "email", nullable = false, length = 20)
	private String email;

	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;

	@Column(name = "last_name", unique = false, nullable = false, length = 20)
	private String lastName;

	@OneToOne(mappedBy="employee",cascade=CascadeType.ALL)
	//@JoinColumn(name = "acct_id")
	private Account account;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String email, String firstName, String lastName) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee Id=" + employeeId + ", email=" + email
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", account info " + account; 
	}

}
