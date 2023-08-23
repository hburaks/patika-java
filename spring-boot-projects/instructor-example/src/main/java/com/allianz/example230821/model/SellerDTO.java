package com.allianz.example230821.model;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

@Data
public class SellerDTO extends BaseDTO {

    private String name;
    private String surname;
    private String tc;
    private String email;
    private String shopName;
    private String taxNumber;
    private String taxOffice;

}
