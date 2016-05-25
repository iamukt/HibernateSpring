package transport;

import org.springframework.stereotype.Component;

@Component("test")
public class TestTransport implements Transport {

	public TestTransport() {
		System.out.println("in constr of " + getClass().getName());
	}

	@Override
	public void communicateWithBank(byte[] data) {
		System.out.println("Informing underlying bank using TEST layer");

	}

}
