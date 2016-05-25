package com.app.core.atm3;


public class HttpTransport implements Transport {
	public HttpTransport() {
		System.out.println("in http tr constr");
	}

	@Override
	public void communicateWithBank(byte[] pkt) {
		System.out.println("Sending data to Bank using HTTP layer : "
				+ new String(pkt));
		

	}

}
