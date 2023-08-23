package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.CategoryEntity;
import com.allianz.example230821.database.entity.ProductEntity;
import com.allianz.example230821.model.CategoryDTO;
import com.allianz.example230821.model.ProductDTO;
import com.allianz.example230821.model.requestDTO.CategoryRequestDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CategoryMapper implements IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {

    @Autowired
    ProductMapper productMapper;

    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {

        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        Set<ProductDTO> productDTOS = new HashSet<>(new ArrayList<>(productMapper.entityListToDTOList(new ArrayList<>(entity.getProductList()))));
        dto.setProductList(productDTOS);
        return dto;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {

        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        Set<ProductEntity> productEntities = new HashSet<>(
                productMapper.dtoListTOEntityList(new ArrayList<>(dto.getProductList())));
        entity.setProductList(productEntities);
        return entity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {

        List<CategoryDTO> dtoList = new ArrayList<>();

        for (CategoryEntity entity : categoryEntities) {
            CategoryDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }


        return dtoList;
    }

    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {
        List<CategoryEntity> entityList = new ArrayList<>();
        for (CategoryDTO dto : categoryDTOS) {
            CategoryEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryRequestDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public List<CategoryEntity> requestDtoListTOEntityList(List<CategoryRequestDTO> categoryRequestDTOS) {
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        for (CategoryRequestDTO categoryRequestDTO : categoryRequestDTOS) {
            categoryEntityList.add(requestDTOToEntity(categoryRequestDTO));
        }
        return categoryEntityList;
    }

    @Override
    public CategoryEntity requestDtoToExistEntity(CategoryEntity entity, CategoryRequestDTO categoryRequestDTO) {
        entity.setName(categoryRequestDTO.getName());
        Set<ProductEntity> productEntitySet =
                new HashSet<>(productMapper.requestDtoListTOEntityList(
                        new ArrayList<>(categoryRequestDTO.getProductList())
                ));
        entity.setProductList(productEntitySet);
        return entity;
    }

    @Override
    public PageDTO<CategoryDTO> pageEntityToPageDTO(Page<CategoryEntity> entityPage) {
        PageDTO<CategoryDTO> dtoPage = new PageDTO<>();
        dtoPage.setTotalPages(entityPage.getTotalPages());
        dtoPage.setTotalElements(entityPage.getTotalElements());
        dtoPage.setSort(entityPage.getSort());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setNumber(entityPage.getNumber());
        dtoPage.setContent(entityListToDTOList(entityPage.getContent()));
        dtoPage.setHasContent(entityPage.hasContent());

        return dtoPage;
    }
}
