package com.mohit.springdemo.mvc.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		ConstraintValidator.super.initialize(theCourseCode);
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result;
		if(theCode!=null) {
			result = theCode.startsWith(coursePrefix);
		}
		else {
			return true;
		}
		return result;
	}


	
//	public void initialize(CourseCode theCourseCode) {
//		coursePrefix = theCourseCode.value();
//	}
//	
//	@Override
//	public boolean isValid(String theCode, ConstraintValidatorContext validatorContext) {
//		
//		boolean result;
//		if(theCode!=null) {
//			result = coursePrefix.startsWith(coursePrefix);
//		}
//		else {
//			return true;
//		}
//		
//		return result;
//	}
//	
}
