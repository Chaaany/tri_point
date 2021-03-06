package com.triple.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActivityType {
	
	ADD_POINT_REVIEW_FIRST(1), ADD_POINT_REVIEW_CONTENT(2), ADD_POINT_REVIEW_PHOTO(3), 
	MINUS_POINT_REVIEW_FIRST(4), MINUS_POINT_REVIEW_CONTENT(5), MINUS_POINT_REVIEW_PHOTO(6) ;

	private final int value;
	
}
