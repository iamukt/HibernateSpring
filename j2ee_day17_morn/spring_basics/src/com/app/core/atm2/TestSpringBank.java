package com.app.core.atm2;

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
		// meta-data info ---xml , class path

		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config2.xml");) {
			System.out.println("spring container started");
			// get located/loaded/inst/Dependency injected rdy made bean from SC
			ATM ref = ctx.getBean(ATM.class);
			// B.L
			ref.deposit(100);
			ATM ref2 = ctx.getBean(ATM.class);
			System.out.println(ref == ref2);
		}

	}

}
