package hib_pojos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountPK implements Serializable {
	private String acctId;
	private String custId;

	public AccountPK() {
		System.out.println("in comp pk constr...");
	}
	

	public AccountPK(String acctId, String custId) {
		super();
		this.acctId = acctId;
		this.custId = custId;
	}
	

	@Column(length = 10)
	public String getAcctId() {
		return acctId;
	}


	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	@Column(length = 10)
	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctId == null) ? 0 : acctId.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
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
		AccountPK other = (AccountPK) obj;
		if (acctId == null) {
			if (other.acctId != null)
				return false;
		} else if (!acctId.equals(other.acctId))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		return true;
	}


}
