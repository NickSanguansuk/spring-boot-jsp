package com.company.spring_jsp.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = MultipartFileEmptyImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipartFileEmpty {

    String message() default "{MultipartFileEmpty}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}