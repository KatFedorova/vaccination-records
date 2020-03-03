package ru.fedorova.vaccination.service;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SnilsConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Snils {
    String message() default "{Snils}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
