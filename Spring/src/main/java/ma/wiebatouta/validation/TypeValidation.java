package ma.wiebatouta.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeValidation implements ConstraintValidator<ExtensionImage,String>{
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.matches(".*[png,jpeg,jpg,PNG,JPEG,JPG]")) {
			return true;
		}else {
			return false;
		}
	}
}
