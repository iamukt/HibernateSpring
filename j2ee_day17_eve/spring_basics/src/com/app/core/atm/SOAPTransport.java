package com.app.core.atm;

public class SOAPTransport implements Transport {
	public SOAPTransport() {
		System.out.println("in soap transport constr");
	}

	@Override
	public void communicateWithBank(byte[] pkt) {
		System.out.println("Sending data to Bank using SOAP layer : "
				+ new String(pkt));
		

	}

}
