package com.dreamcashgroup.dcash.common.validator;

import com.dreamcashgroup.dcash.common.annotation.MatchPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, PasswordResetDto> {

    private Boolean allowNull;

    @Override
    public void initialize(MatchPassword constraintAnnotation) {
        allowNull = constraintAnnotation.allowNull();
    }

    @Override
    public boolean isValid(PasswordResetDto value, ConstraintValidatorContext context) {
        String password = value.getPassword();
        String confirmPassword = value.getPasswordConfirmation();
        if (allowNull) {
            return password == null && confirmPassword == null;
        }
        return password.equals(confirmPassword);
    }
}

