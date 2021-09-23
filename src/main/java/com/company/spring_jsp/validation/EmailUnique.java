package com.company.spring_jsp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailUniqueImp.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnique {

    String message() default "{UserEmailUnique}";

    Class<?>[] group() default {};

    Class<? extends Payload>[] payload() default {};
}
