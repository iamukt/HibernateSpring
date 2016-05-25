package com.app.core.atm3;

public class SOAPTransport implements Transport {

	@Override
	public void communicateWithBank(byte[] pkt) {
		System.out.println("Sending data to Bank using SOAP layer : "
				+ new String(pkt));
		

	}

}
