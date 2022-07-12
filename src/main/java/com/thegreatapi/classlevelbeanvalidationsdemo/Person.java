package com.thegreatapi.classlevelbeanvalidationsdemo;

import com.thegreatapi.classlevelbeanvalidationsdemo.validation.ShouldHavePartnerIfMarried;

@ShouldHavePartnerIfMarried
public final class Person {

    private final String name;

    private Person partner;

    private boolean married;

    public Person(String name) {
        this.name = name;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public Person getPartner() {
        return partner;
    }

    public boolean isMarried() {
        return married;
    }
}
