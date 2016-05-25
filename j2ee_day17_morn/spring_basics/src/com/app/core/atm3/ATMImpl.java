//combination of setter & constr based D.I
package com.app.core.atm3;

public class ATMImpl implements ATM {

	private Transport transport;
	private double cash;

	// constr based d.i.
	public ATMImpl(double cash) {
		
		this.cash = cash;
		System.out.println("in atm constr "+cash);
	}
	//init ----BOTH

	@Override
	public void deposit(double amt) {
		cash += amt;
		StringBuilder sb = new StringBuilder("Deposting Funds amt=" + amt
				+ " cash " + cash);
		transport.communicateWithBank(sb.toString().getBytes());
	}

	@Override
	public void withdraw(double amt) {
		cash -= amt;
		StringBuilder sb = new StringBuilder("Withdrawing Funds amt=" + amt
				+ " cash" + cash);
		transport.communicateWithBank(sb.toString().getBytes());

	}
	//setter based d.i
	public void setTransport(Transport transport) {
		System.out.println("In setter of ATMIMPL");
		this.transport = transport;
	}

}
