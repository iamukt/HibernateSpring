package com.app.simple6_ref;

import java.util.*;

public class Product {
	private Set<Part> parts;

	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}

	public Set<Part> getParts() {
		return parts;
	}
}
