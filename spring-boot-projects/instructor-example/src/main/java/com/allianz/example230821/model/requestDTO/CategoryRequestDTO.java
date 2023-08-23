package com.allianz.example230821.model.requestDTO;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryRequestDTO extends BaseDTO {
    private String name;
    private Set<ProductRequestDTO> productList = new HashSet<>();
}
