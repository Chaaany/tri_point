package com.triple.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointScore {
	BASIC(1), BONUS(1);

	private final int value;
	
	
}
