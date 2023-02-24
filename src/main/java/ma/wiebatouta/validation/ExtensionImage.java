package ma.wiebatouta.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TypeValidation.class)
public @interface ExtensionImage {
	String message() default "Accepted format JPEG,PNG,JPG";
}
