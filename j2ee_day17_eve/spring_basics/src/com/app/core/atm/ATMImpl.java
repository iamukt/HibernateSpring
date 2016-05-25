package com.app.core.atm;


public class ATMImpl implements ATM {
	//private TestTransport transport = new TestTransport();
	private Transport transport;//=new HttpTransport();

	public ATMImpl() {
		System.out.println("atm constr  "+transport);
	}
	public void anyInit()
	{
		System.out.println("in init ");
	}
	public void anyDestroy()
	{
		System.out.println("in destroy ");
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

	public void setTransport(Transport transport) {
		System.out.println("in set transport");
		this.transport = transport;
	}
	

}
