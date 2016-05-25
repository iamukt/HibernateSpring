package com.app.spel;

import java.util.Arrays;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionTest {

	public static void main(String[] args) {

		// Create SpelExp parser object
		ExpressionParser parser = new SpelExpressionParser();

		Expression expression = parser
				.parseExpression(" 'Testing Spring Expression Framework' ");
		String message = (String) expression.getValue();
		System.out.println("Message is " + message);

		// example of method invocation
		expression = parser.parseExpression(" 'Hello World'.concat('!!!!')");
		message = (String) expression.getValue();
		System.out.println("Message is " + message);
		// example of Javabean property --- getter --- invokes getBytes
		expression = parser.parseExpression("'Hello World'.bytes");
		byte[] bytes = (byte[]) expression.getValue();
		System.out.println("Byte[] = " + Arrays.toString(bytes));
		// example of nested properties using dot notation
		expression = parser.parseExpression(" 'Hello Again'.bytes.length");
		int length = (Integer) expression.getValue();
		System.out.println("Byte array length " + length);
		// constructor invocation example
		expression = parser
				.parseExpression("new String('hello everyone').toUpperCase()");
		/*
		 * public <T> T getValue(Class<T> desiredResultType). Using this method
		 * removes the need to cast the value of the expression to the desired
		 * result type. An EvaluationException will be thrown if the value
		 * cannot be cast to the type T or converted using the registered type
		 * converter.
		 */
		message = expression.getValue(String.class);
		System.out.println("constr eg " + message);
	}
}
