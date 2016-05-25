package transport;

import org.springframework.stereotype.Component;

@Component("http")
public class HttpTransport implements Transport {

	public HttpTransport() {
		System.out.println("in constr of " + getClass().getName());
	}

	@Override
	public void communicateWithBank(byte[] data) {
		System.out.println("Informing underlying bank using HTTP layer");

	}

}
