package com.triple.constants;

public enum PointType {
	REVIEW_BASIC(1), REVIEW_BONUS(2);

	private final int value;
	
	PointType(int value) {
		this.value = value;
	} 
	
	public int getValue() {
		return value;
	}
	
}
