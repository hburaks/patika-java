package com.allianz.instructorExample.model.requestDTO;

import com.allianz.instructorExample.util.BaseDTO;
import lombok.Data;

@Data
public class PersonRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;

}
