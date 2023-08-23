package com.allianz.example230821.model.requestDTO;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

@Data
public class PersonRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;
    private String mail;


}
