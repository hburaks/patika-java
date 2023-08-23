package com.allianz.example230821.model.requestDTO;

import com.allianz.example230821.model.enums.ColorEnum;
import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class ProductRequestDTO extends BaseDTO {

    private String name;
    private String code;
    private ColorEnum color;
    private BigDecimal sellPrice;
    private BigDecimal buyPrice;
    private Integer quantity;
    private Set<CategoryRequestDTO> categoryList;
    private TaxRequestDTO tax;

}
