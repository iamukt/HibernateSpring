package com.app.simple6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("beans6.xml");

      JavaCollection jc=context.getBean
    		  ("javaCollection",JavaCollection.class);

      jc.getAddressList();
      jc.getAddressSet();
      jc.getAddressMap();
      jc.getAddressProp();
      System.out.println(jc.getDateList());
   }
}