package com.triple.type;

public enum PointScore {
	BASIC(1), BONUS(2);

	private final int value;
	
	PointScore(int value) {
		this.value = value;
	} 
	
	public int getValue() {
		return value;
	}
	
}
