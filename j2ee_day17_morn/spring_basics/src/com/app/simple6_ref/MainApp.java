package com.app.simple6_ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("beans6-ref.xml");

      Product p=context.getBean(Product.class);
      System.out.println("Printing part names");
     for (Part p1 : p.getParts())
    	 System.out.println(p1.getName());
   }
}