package com.app.core.atm1;

public class SOAPTransport implements Transport {

	@Override
	public void communicateWithBank(byte[] pkt) {
		System.out.println("Sending data to Bank using SOAP layer : "
				+ new String(pkt));
		

	}

}
