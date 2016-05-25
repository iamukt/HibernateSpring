//dependent bean TextEditor -- its dependency --SpellChecker
package com.app.simple;

public class TextEditor {
	private SpellChecker spellChecker123;
	private SpellChecker spellChecker1234;

	public TextEditor() {
		System.out.println("in text editor constr...");
	}

	public void setSpellChecker123(SpellChecker spellChecker123) {
		System.out.println("inside setter of spellchker 123");
		this.spellChecker123 = spellChecker123;
	}
	public void setSpellChecker1234(SpellChecker spellChecker1234) {
		System.out.println("inside setter of spellchker 1234");
	}
	//B.L
	public void spellCheck() {
		spellChecker123.checkSpelling();
	}
}