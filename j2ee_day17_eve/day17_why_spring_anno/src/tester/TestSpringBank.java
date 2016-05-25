package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import atm.ATM;

public class TestSpringBank {

	public static void main(String[] args) {
		// create SC
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-config.xml")) {
			System.out.println("SC started");
			//get bean from SC
			ATM ref=ctx.getBean("atm123",ATM.class);
			//B.L
			ref.deposit(100);
			ref.withdraw(300);
			
			ATM ref2=ctx.getBean("atm123",ATM.class);
			System.out.println(ref==ref2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
