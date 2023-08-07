package com.allianz.instructorExample.model;

import com.allianz.instructorExample.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private List<AddressDTO> addressList;
}
