package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.ProductEntity;
import com.allianz.example230821.database.repository.ProductEntityRepository;
import com.allianz.example230821.database.specification.ProductSpecification;
import com.allianz.example230821.mapper.ProductMapper;
import com.allianz.example230821.model.ProductDTO;
import com.allianz.example230821.model.requestDTO.ProductRequestDTO;
import com.allianz.example230821.service.ProductService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController extends BaseController<
        ProductEntity,
        ProductDTO,
        ProductRequestDTO,
        ProductMapper,
        ProductEntityRepository,
        ProductSpecification,
        ProductService> {

    @Autowired
    ProductService productService;

    @Override
    protected ProductService getService() {
        return this.productService;
    }

    @PostMapping("add-others")
    public ResponseEntity<ProductDTO> addOtherRelations(@RequestBody ProductRequestDTO productRequestDTO) {
        return new ResponseEntity<>(productService.saveWithCategory(productRequestDTO), HttpStatus.OK);

    }
}