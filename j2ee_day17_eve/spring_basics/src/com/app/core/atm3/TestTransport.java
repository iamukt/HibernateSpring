package com.app.core.atm3;

public class TestTransport implements Transport {
	public TestTransport() {
		System.out.println("in test tr constr...");
	}

	@Override
	public void communicateWithBank(byte[] pkt) {
		System.out.println("Sending data to Bank using Test layer : "
				+ new String(pkt));
		

	}

}
