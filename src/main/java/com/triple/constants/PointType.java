package com.triple.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PointType {
	REVIEW_BASIC(1), REVIEW_BONUS(2);

	private final int value;
}
