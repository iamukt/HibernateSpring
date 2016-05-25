package transport;

import org.springframework.stereotype.Component;

@Component
public class SoapTransport implements Transport {

	public SoapTransport() {
		System.out.println("in constr of " + getClass().getName());
	}

	@Override
	public void communicateWithBank(byte[] data) {
		System.out.println("Informing underlying bank using SOAP layer");

	}

}
