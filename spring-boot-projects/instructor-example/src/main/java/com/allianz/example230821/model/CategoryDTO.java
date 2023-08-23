package com.allianz.example230821.model;

import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDTO extends BaseDTO {
    private String name;
    private Set<ProductDTO> productList = new HashSet<>();
}
