package com.allianz.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PersonDTO {
    private UUID uuid;
    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    public PersonDTO() {
        this.uuid = UUID.randomUUID();
    }
}
