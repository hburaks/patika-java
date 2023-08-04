package com.allianz.instructorexample.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Person {

    private UUID uuid;
    private String name;
    private String surname;
    private int birthYear;
    private String tc;

    public Person() {
        this.uuid = UUID.randomUUID();
    }
}
