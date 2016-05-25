//dependent bean TextEditor -- its dependency --SpellChecker
package com.app.simple;

public class TextEditor {
	private SpellChecker spellChecker123;

	public TextEditor() {
		System.out.println("in text editor constr...");
	}

	public void setSpellChecker123(SpellChecker spellChecker123) {
		System.out.println("inside setter of spellchker 123");
		this.spellChecker123 = spellChecker123;
	}
	//B.L
	public void spellCheck() {
		spellChecker123.checkSpelling();
	}
}