package com.triple.type;

public enum AttachedActivityType {
	REVIEW(1);
	
	private final int value;
	
	AttachedActivityType(int value) {
		this.value = value;
	} 
	
	public int getValue() {
		return value;
	}
	
}
