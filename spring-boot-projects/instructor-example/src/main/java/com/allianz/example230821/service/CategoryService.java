package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.CategoryEntity;
import com.allianz.example230821.database.repository.CategoryEntityRepository;
import com.allianz.example230821.database.specification.CategorySpecification;
import com.allianz.example230821.mapper.CategoryMapper;
import com.allianz.example230821.model.CategoryDTO;
import com.allianz.example230821.model.requestDTO.CategoryRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<CategoryEntity, CategoryDTO, CategoryRequestDTO,
        CategoryMapper, CategoryEntityRepository, CategorySpecification> {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategorySpecification categorySpecification;

    @Override
    protected CategoryMapper getMapper() {
        return this.categoryMapper;
    }

    @Override
    protected CategoryEntityRepository getRepository() {
        return this.categoryEntityRepository;
    }

    @Override
    protected CategorySpecification getSpecification() {
        return categorySpecification;
    }
}
