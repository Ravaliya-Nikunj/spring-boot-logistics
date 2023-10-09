package com.example.logistics.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginTypeValidator.class)
@Documented
public @interface ValidLoginType {
    String message() default "Invalid Login type.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
