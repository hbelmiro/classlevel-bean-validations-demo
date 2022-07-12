package com.thegreatapi.classlevelbeanvalidationsdemo;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void marriedWithoutPartnerShouldBeInvalid() {
        Person person = new Person("John");
        person.setMarried(true);
        person.setPartner(null);

        Validator validator;
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        assertThat(violations).hasSize(1);
    }

    @Test
    void marriedWithPartnerShouldBeValid() {
        Person john = new Person("John");
        Person mary = new Person("Mary");

        john.setPartner(mary);
        john.setMarried(true);

        Validator validator;
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }

        Set<ConstraintViolation<Person>> violations = validator.validate(john);

        assertThat(violations).isEmpty();
    }

    @Test
    void notMarriedWithPartnerShouldBeInvalid() {
        Person person = new Person("John");
        Person mary = new Person("Mary");
        person.setMarried(false);
        person.setPartner(mary);

        Validator validator;
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        assertThat(violations).hasSize(1);
    }

    @Test
    void notMarriedWithoutPartnerShouldBeValid() {
        Person person = new Person("John");
        person.setMarried(false);
        person.setPartner(null);

        Validator validator;
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        assertThat(violations).isEmpty();
    }
}