package Service;

import Motocycle.Motorcycle;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

public class Validator{
	private final javax.validation.Validator validator;
	Validator (){
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
	public void valid(Motorcycle motorcycle){
		Set<ConstraintViolation<Motorcycle>> constraintViolations = validator.validate(motorcycle);
		for(ConstraintViolation constraintViolation : constraintViolations){
			String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
			System.out.println(fieldName + " " + constraintViolation.getMessage());
			throw new RuntimeException();
		}
	}
}
