package com.allianz.example230821.model;


import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO extends BaseDTO {
    private PersonDTO person;
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderDTO> orderList;

}
