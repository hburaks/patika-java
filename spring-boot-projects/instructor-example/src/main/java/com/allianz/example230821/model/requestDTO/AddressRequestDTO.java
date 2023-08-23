package com.allianz.example230821.model.requestDTO;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {

    private String title;
    private String address;
}
