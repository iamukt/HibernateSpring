package com.app.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext(
            		 "beans-autowire.xml");
      System.out.println("SC started.....");
      TextEditor te = (TextEditor) context.getBean("textEditor");

      te.spellCheck();
      ((ClassPathXmlApplicationContext)context).close();
   }
}