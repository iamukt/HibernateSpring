package com.app.core.atm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringBank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// start spring container --- i/f for spring container =
		// ApplicationContext=
		// env in which spring appln (spring beans) are loaded
		// org.springframework.context
		// meta-data info ---xml , classs path

		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config.xml");) {
			System.out.println("spring container started");
			// ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
			// get located,loaded,instantiated,Dependency injected ready made
			// bean from SC
			ATM ref = ctx.getBean("my_atm", ATM.class);
			// B.L
			ref.deposit(500);
			// get bean from SC again
			ATM ref2 = ctx.getBean("my_atm", ATM.class);
			ref.withdraw(100);
			System.out.println(ref == ref2);
		}
		// ((ClassPathXmlApplicationContext) ctx).close();

	}

}
