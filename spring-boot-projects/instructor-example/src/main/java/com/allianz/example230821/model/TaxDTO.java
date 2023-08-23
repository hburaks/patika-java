package com.allianz.example230821.model;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}
