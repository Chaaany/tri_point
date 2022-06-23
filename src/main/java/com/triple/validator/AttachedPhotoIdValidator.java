package com.triple.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.triple.annotation.AttachedPhotoId;

public class AttachedPhotoIdValidator implements ConstraintValidator<AttachedPhotoId, List<String>> {

	@Override
	public boolean isValid(List<String> value, ConstraintValidatorContext context) {
		if (value.size() != 0) {
			for (String photoId : value) {
				if (!photoId.matches("^[0-9a-f]{8}-[0-9a-f]{4}-[0-5][0-9a-f]{3}-[089ab][0-9a-f]{3}-[0-9a-f]{12}$"))
					return false;
			}
		}
		return true;
	}

}
