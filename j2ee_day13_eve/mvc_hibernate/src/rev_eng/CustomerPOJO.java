package rev_eng;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MY_CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="MY_CUSTOMERS")
//@NamedQuery(name="CustomerPOJO.findAll", query="SELECT c FROM CustomerPOJO c")
public class CustomerPOJO  {
	
	private Integer id;
	private double depositAmt;
	private String email;
	private String name;
	private String password;
	private Date regDate;
	private String role;

	public CustomerPOJO() {
	}


	@Id
//	@SequenceGenerator(name="MY_CUSTOMERS_ID_GENERATOR", sequenceName="MY_SEQ")
	@GeneratedValue//(strategy=GenerationType.SEQUENCE, generator="MY_CUSTOMERS_ID_GENERATOR")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="DEPOSIT_AMT")
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
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="REG_DATE")
	public Date getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Column(name="\"ROLE\"")
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "CustomerPOJO [id=" + id + ", depositAmt=" + depositAmt
				+ ", email=" + email + ", name=" + name + ", regDate="
				+ regDate + ", role=" + role + "]";
	}
	

}