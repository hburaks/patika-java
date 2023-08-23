package com.allianz.example230821.model;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    private String title;
    private String address;

    //private PersonDTO person;

}
