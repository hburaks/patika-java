package com.allianz.genericerpcrud.dto;

import com.allianz.genericerpcrud.dto.generic.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    private String title;
    private String address;

    //private PersonDTO person;

}
