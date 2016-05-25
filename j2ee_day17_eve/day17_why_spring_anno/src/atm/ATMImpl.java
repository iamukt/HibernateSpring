package atm;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import transport.HttpTransport;
import transport.TestTransport;
import transport.Transport;

@Component("atm123")
public class ATMImpl implements ATM {
	@Autowired
	@Qualifier("soapTransport")
	private Transport transport123;

	public ATMImpl() {
		System.out.println("in constr of " + getClass().getName()
				+ "transport " + transport123);
	}
	@Override
	public void withdraw(double amt) {
		StringBuilder sb = new StringBuilder("withdrawing funds ");
		System.out.println("in withdraw " + amt);
		transport123.communicateWithBank(sb.toString().getBytes());

	}

	@Override
	public void deposit(double amt) {
		StringBuilder sb = new StringBuilder("depositing funds ");
		System.out.println("in deposit " + amt);
		transport123.communicateWithBank(sb.toString().getBytes());

	}
	@PostConstruct
	// one time inits
	public void myInit()
	{
		System.out.println("in init "+transport123);
	}
	//destroy style method --to be called by SC before GC
	@PreDestroy
	public void myDestroy()
	{
		System.out.println("in destroy "+transport123);
	}

}
