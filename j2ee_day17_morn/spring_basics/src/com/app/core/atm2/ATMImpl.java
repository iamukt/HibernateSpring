//factory based D.I
package com.app.core.atm2;


public class ATMImpl implements ATM {
	//private TestTransport transport = new TestTransport();
	private Transport transport;//=new HttpTransport();

	private ATMImpl() {
		System.out.println("in atm impl private constr");
	}
	@Override
	public void deposit(double amt) {
		StringBuilder sb = new StringBuilder("Deposting Funds amt=" + amt);
		transport.communicateWithBank(sb.toString().getBytes());
	}

	@Override
	public void withdraw(double amt) {
		StringBuilder sb = new StringBuilder("Withdrawing Funds amt=" + amt);
		transport.communicateWithBank(sb.toString().getBytes());

	}
	public static ATMImpl getInstance(Transport transport)
	{
		System.out.println("in static factory method");
		ATMImpl ref=new ATMImpl();
		ref.transport=transport;
		System.out.println(transport);
		return ref;
	}

	

}
