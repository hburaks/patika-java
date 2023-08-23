package com.allianz.example230821.model;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private String mail;
    private List<AddressDTO> addressList;

}


