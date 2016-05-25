package com.app.simple1;



public class TextEditor {

	private SpellChecker[] spellChecker123;

	public TextEditor() {
		System.out.println("in text editor constr");
	}
	
	public void setSpellChecker123(SpellChecker[] spellChecker123) {
		this.spellChecker123 = spellChecker123;
	}

	public void spellCheck() {
		for(SpellChecker c :spellChecker123)
			c.checkSpelling();
	}
}