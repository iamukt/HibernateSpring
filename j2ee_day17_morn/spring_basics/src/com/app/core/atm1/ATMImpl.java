//constructor based D.I
package com.app.core.atm1;


public class ATMImpl implements ATM {
	//private TestTransport transport = new TestTransport();
	private Transport transport;//=new HttpTransport();

	public ATMImpl(Transport transport1) {
		this.transport=transport1;
		System.out.println("atm constr  "+this.transport);
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
	public void init()
	{
		System.out.println("in init");
	}
	public void dest()
	{
		System.out.println("in dest");
	}
}
