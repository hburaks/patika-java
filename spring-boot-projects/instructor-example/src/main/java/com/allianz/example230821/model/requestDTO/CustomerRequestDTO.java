package com.allianz.example230821.model.requestDTO;


import com.allianz.example230821.model.PersonDTO;
import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequestDTO extends BaseDTO {
    private PersonDTO person;
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderRequestDTO> orderList;

}
