package com.allianz.instructorExample.model.requestDTO;

import com.allianz.instructorExample.util.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {

    private String title;
    private String address;
}
