package com.allianz.example230821.model;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO extends BaseDTO {
    private ProductDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
