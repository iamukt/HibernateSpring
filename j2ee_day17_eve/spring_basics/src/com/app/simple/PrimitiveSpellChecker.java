package com.app.simple;

public class PrimitiveSpellChecker implements SpellChecker{
   public PrimitiveSpellChecker(){
      System.out.println("Inside Prim SpellChecker constructor." );
   }

   @Override
   public void checkSpelling(){
      System.out.println("checkSpelling using Primitive checker" );
   }
   
}