package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.CategoryEntity;
import com.allianz.example230821.database.repository.CategoryEntityRepository;
import com.allianz.example230821.database.specification.CategorySpecification;
import com.allianz.example230821.mapper.CategoryMapper;
import com.allianz.example230821.model.CategoryDTO;
import com.allianz.example230821.model.requestDTO.CategoryRequestDTO;
import com.allianz.example230821.service.CategoryService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<
        CategoryEntity,
        CategoryDTO,
        CategoryRequestDTO,
        CategoryMapper,
        CategoryEntityRepository,
        CategorySpecification,
        CategoryService> {

    @Autowired
    CategoryService categoryService;

    @Override
    protected CategoryService getService() {
        return this.categoryService;
    }
}