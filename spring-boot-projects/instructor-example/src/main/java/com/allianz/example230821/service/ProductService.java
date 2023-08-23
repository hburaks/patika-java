package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.ProductEntity;
import com.allianz.example230821.database.repository.ProductEntityRepository;
import com.allianz.example230821.database.specification.ProductSpecification;
import com.allianz.example230821.mapper.ProductMapper;
import com.allianz.example230821.model.CategoryDTO;
import com.allianz.example230821.model.ProductDTO;
import com.allianz.example230821.model.requestDTO.CategoryRequestDTO;
import com.allianz.example230821.model.requestDTO.ProductRequestDTO;
import com.allianz.example230821.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService extends BaseService<ProductEntity, ProductDTO, ProductRequestDTO,
        ProductMapper, ProductEntityRepository, ProductSpecification> {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductSpecification productSpecification;

    @Override
    protected ProductMapper getMapper() {
        return this.productMapper;
    }

    @Override
    protected ProductEntityRepository getRepository() {
        return this.productEntityRepository;
    }

    @Override
    protected ProductSpecification getSpecification() {
        return productSpecification;
    }

    @Transactional
    public ProductDTO saveWithCategory(ProductRequestDTO productRequestDTO) {
        Set<CategoryRequestDTO> categoryRequestDTOS = new HashSet<>(new ArrayList<>(productRequestDTO.getCategoryList()));
        productRequestDTO.setCategoryList(null);
        productRequestDTO.setTax(null);
        ProductDTO productDTO = productMapper.entityToDTO(productEntityRepository.save(productMapper.requestDTOToEntity(productRequestDTO)));
        for (CategoryRequestDTO categoryRequestDTO : categoryRequestDTOS) {
            if (productDTO.getCategoryList() != null) {
                productDTO.getCategoryList().add(categoryService.getByUUID(categoryRequestDTO.getUuid()));
                // Relation'ı kaydet.
//                categoryService.getByUUID(categoryRequestDTO.getUuid()).setProductList();
            } else {
                Set<CategoryDTO> categoryDTOS = new HashSet<>();
                categoryDTOS.add(categoryService.getByUUID(categoryRequestDTO.getUuid()));
                productDTO.setCategoryList(categoryDTOS);
            }
        }

        getRepository().save(productMapper.dtoToEntity(productDTO));
        return productDTO;

    }
}
