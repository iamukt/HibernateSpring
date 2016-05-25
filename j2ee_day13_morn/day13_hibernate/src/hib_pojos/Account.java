package hib_pojos;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="AccountCompPK")
@Table(name = "dac_accts")
public class Account {
	private AccountPK id;
	private String type, name;
	private double balance;

	public Account() {
		System.out.println("in acct constr");
	}

	public Account(String type, String name, double balance) {
		super();
		this.type = type;
		this.name = name;
		this.balance = balance;
	}

	
	@Id
	public AccountPK getId() {
		return id;
	}

	public void setId(AccountPK id) {
		this.id = id;
	}

	@Column(length = 10)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(columnDefinition = "decimal(8,2)")
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account key=" + id + ", type=" + type + ", name=" + name
				+ ", balance=" + balance ;
	}

}
