package com.allianz.erp.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private String name;

    private String info;

    private int stock;

    private BigDecimal price;

}
