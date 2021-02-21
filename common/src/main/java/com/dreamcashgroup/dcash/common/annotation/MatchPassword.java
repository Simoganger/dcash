package com.dreamcashgroup.dcash.common.annotation;

import com.dreamcashgroup.dcash.common.validator.MatchPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchPasswordValidator.class)
@Documented
public @interface MatchPassword {

    String message() default "Passwords must match";
    Class<?>[] groups() default {};
    boolean allowNull() default false;
    Class<? extends Payload>[] payload() default {};
}