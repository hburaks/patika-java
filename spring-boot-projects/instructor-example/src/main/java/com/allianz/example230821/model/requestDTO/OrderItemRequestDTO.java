package com.allianz.example230821.model.requestDTO;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequestDTO extends BaseDTO {
    private ProductRequestDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
