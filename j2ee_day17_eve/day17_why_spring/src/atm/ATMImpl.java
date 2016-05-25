package atm;

import transport.HttpTransport;
import transport.TestTransport;
import transport.Transport;

public class ATMImpl implements ATM {
	private Transport transport;

	public ATMImpl() {
		System.out.println("in constr of " + getClass().getName()
				+ "transport " + transport);
	}

	public void setTransport(Transport transport) {
		System.out.println("in setter");
		this.transport = transport;
	}

	@Override
	public void withdraw(double amt) {
		StringBuilder sb = new StringBuilder("withdrawing funds ");
		System.out.println("in withdraw " + amt);
		transport.communicateWithBank(sb.toString().getBytes());

	}

	@Override
	public void deposit(double amt) {
		StringBuilder sb = new StringBuilder("depositing funds ");
		System.out.println("in deposit " + amt);
		transport.communicateWithBank(sb.toString().getBytes());

	}
	// one time inits
	public void myInit()
	{
		System.out.println("in init "+transport);
	}
	//destroy style method --to be called by SC before GC
	public void myDestroy()
	{
		System.out.println("in destroy "+transport);
	}

}
