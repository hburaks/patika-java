package com.allianz.instructorExample.model;

import com.allianz.instructorExample.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    private String title;
    private String address;

    //private PersonDTO person;

}
