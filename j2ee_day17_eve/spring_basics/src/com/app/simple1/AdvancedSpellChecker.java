package com.app.simple1;

public class AdvancedSpellChecker implements SpellChecker{
   public AdvancedSpellChecker(){
      System.out.println("Inside Advanced SpellChecker constructor." );
   }

   @Override
   public void checkSpelling(){
      System.out.println("checkSpelling using Advanced checker" );
   }
   
}