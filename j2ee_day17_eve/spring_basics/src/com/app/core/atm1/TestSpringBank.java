package com.app.core.atm1;

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

		ApplicationContext ctx =
				new ClassPathXmlApplicationContext(
				"spring-config1.xml");
		//registers with SC --- ctx closing cmd @ JVM termination.
		((ClassPathXmlApplicationContext)ctx).registerShutdownHook();
		System.out.println("spring container started");
		//get located/loaded/inst/Dependency injected rdy made bean from SC
		ATM ref=ctx.getBean(ATM.class);
		//B.L
		ref.deposit(100);
	//	Transport transport=ctx.getBean("soap",Transport.class);
//		System.out.println("main over..."+transport);
		((ClassPathXmlApplicationContext)ctx).close();

	}

}
