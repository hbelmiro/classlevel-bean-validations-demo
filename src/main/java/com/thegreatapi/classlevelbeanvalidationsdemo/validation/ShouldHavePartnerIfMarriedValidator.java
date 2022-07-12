package com.thegreatapi.classlevelbeanvalidationsdemo.validation;

import com.thegreatapi.classlevelbeanvalidationsdemo.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public final class ShouldHavePartnerIfMarriedValidator implements ConstraintValidator<ShouldHavePartnerIfMarried, Person> {

    @Override
    public boolean isValid(Person value, ConstraintValidatorContext context) {
        if (value.isMarried()) {
            return value.getPartner() != null;
        } else {
            return value.getPartner() == null;
        }
    }
}
