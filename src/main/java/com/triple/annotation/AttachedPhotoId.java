package com.triple.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.triple.validator.AttachedPhotoIdValidator;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = AttachedPhotoIdValidator.class)
public @interface AttachedPhotoId {
	
	String message() default "attachedPhotoIds";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
