package ma.wiebatouta.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeValidation implements ConstraintValidator<ExtensionImage, byte[]>{
	@Override
	public boolean isValid(byte[] value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}


}
