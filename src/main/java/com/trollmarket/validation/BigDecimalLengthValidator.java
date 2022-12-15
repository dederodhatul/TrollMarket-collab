package com.trollmarket.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class BigDecimalLengthValidator implements ConstraintValidator<BigDecimalLength, BigDecimal> {
    private int min;

    @Override
    public boolean isValid(BigDecimal bigDecimal, ConstraintValidatorContext constraintValidatorContext) {
        return bigDecimal == null || bigDecimal.toString().length() >= min;
    }

    @Override
    public void initialize(BigDecimalLength constraintAnnotation) {
        this.min = constraintAnnotation.minLength();
    }
}
