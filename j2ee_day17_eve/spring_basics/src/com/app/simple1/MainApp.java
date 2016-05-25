package com.app.simple1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext
             ("beans-autowire1.xml");
      System.out.println("Sc started...");
      //Inherited API of ClassPathXmlApplicationContext --- 
      //rets bean inst --- getBean(String beanId,Class<T> c)
      TextEditor te = context.getBean("textEditor",TextEditor.class);

      te.spellCheck();
   }
}