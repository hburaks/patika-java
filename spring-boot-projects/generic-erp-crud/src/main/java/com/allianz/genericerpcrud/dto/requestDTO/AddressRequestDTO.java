package com.allianz.genericerpcrud.dto.requestDTO;

import com.allianz.genericerpcrud.dto.generic.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {

    private String title;
    private String address;
}
