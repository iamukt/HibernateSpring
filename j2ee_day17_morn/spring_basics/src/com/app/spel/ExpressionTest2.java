package com.app.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExpressionTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spel_beans.xml");
		NumberGuess guess= ctx.getBean(NumberGuess.class);
		System.out.println("Random Number=" +guess.getRandomNumber());
		System.out.println("Java Home "+guess.getJavaHome());

	}

}
