package one_to_one_pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dac_acct1")
public class Account {
	@Id
	@Column(name="employee_id",nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="employee"))
	private Integer accountId;

	@Column(length = 20)
	private String type;

	@Column(columnDefinition = "decimal(8,2)")
	private double balance;

	/*
	 * In a bidirectional relationship, one of the sides (and only one) has to
	 * be the owner: the owner is responsible for the association column(s)
	 * update. To declare a side as not responsible for the relationship, the
	 * attribute mappedBy is used. mappedBy refers to the property name of the
	 * association on the owner side.
	 */
	@OneToOne/*(mappedBy = "account")*/
	@PrimaryKeyJoinColumn
	// to tell hibernate that account is dependent on owner entity for mapping.
	private Employee employee;

	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String type, double balance) {
		super();
		this.type = type;
		this.balance = balance;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", type=" + type
				+ ", balance=" + balance +"owned by "+employee.getFirstName();
	}
	

}
