package com.app.simple2;

public class TextEditor {
	private SpellChecker spellChecker;

	// if constr arg name same as any particular bean id(dependency bean id) , then
	// autowire=constructor
	// matches it by prop name(autowire by name), if not then goes by autowire
	// by type
	public TextEditor(SpellChecker primSpellChecker123) {
		System.out.println("in constr of "+getClass().getName());
		this.spellChecker = primSpellChecker123;
	}

	public void spellCheck() {

		spellChecker.checkSpelling();
	}
}