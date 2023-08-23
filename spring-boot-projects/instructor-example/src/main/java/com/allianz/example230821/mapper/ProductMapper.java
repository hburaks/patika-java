package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.CategoryEntity;
import com.allianz.example230821.database.entity.ProductEntity;
import com.allianz.example230821.model.CategoryDTO;
import com.allianz.example230821.model.ProductDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.model.requestDTO.ProductRequestDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {

    @Autowired
    TaxMapper taxMapper;

    @Autowired
    @Lazy
    CategoryMapper categoryMapper;

    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setQuantity(entity.getQuantity());
        dto.setColor(entity.getColor());
        if (entity.getTax() != null) {

            dto.setTax(taxMapper.entityToDTO(entity.getTax()));
        }
        dto.setSellPrice(entity.getSellPrice());
        dto.setBuyPrice(entity.getBuyPrice());
        if (entity.getCategoryList() != null) {
            Set<CategoryDTO> categoryDTOS =
                    new HashSet<>(new ArrayList<>(categoryMapper.entityListToDTOList(new ArrayList<>(entity.getCategoryList()))));
            dto.setCategoryList(categoryDTOS);
        }

        return dto;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setQuantity(dto.getQuantity());
        entity.setColor(dto.getColor());
        if (dto.getTax() != null) {
            entity.setTax(taxMapper.dtoToEntity(dto.getTax()));
        }
        entity.setSellPrice(dto.getSellPrice());
        entity.setBuyPrice(dto.getBuyPrice());
        if (dto.getCategoryList() != null) {

            Set<CategoryEntity> categoryDTOS =
                    new HashSet<>(new ArrayList<>(categoryMapper.dtoListTOEntityList(new ArrayList<>(dto.getCategoryList()))));
            entity.setCategoryList(categoryDTOS);
        }

        return entity;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> dtoList = new ArrayList<>();
        for (ProductEntity entity : productEntities) {
            ProductDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {
        List<ProductEntity> entityList = new ArrayList<>();
        for (ProductDTO dto : productDTOS) {
            ProductEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {
        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setQuantity(dto.getQuantity());
        entity.setColor(dto.getColor());
        if (dto.getTax() != null) {
            entity.setTax(taxMapper.requestDTOToEntity(dto.getTax()));
        }
        entity.setSellPrice(dto.getSellPrice());
        entity.setBuyPrice(dto.getBuyPrice());
        if (dto.getCategoryList() != null) {

            Set<CategoryEntity> categoryDTOS =
                    new HashSet<>(new ArrayList<>(categoryMapper.requestDtoListTOEntityList(new ArrayList<>(dto.getCategoryList()))));
            entity.setCategoryList(categoryDTOS);
        }
        return entity;
    }

    @Override
    public List<ProductEntity> requestDtoListTOEntityList(List<ProductRequestDTO> productRequestDTOS) {
        return null;
    }

    @Override
    public ProductEntity requestDtoToExistEntity(ProductEntity entity, ProductRequestDTO productRequestDTO) {
        Set<CategoryEntity> categoryEntitySet = new HashSet<>(categoryMapper.requestDtoListTOEntityList(new ArrayList<>(productRequestDTO.getCategoryList())));
        entity.setCategoryList(categoryEntitySet);
        entity.setTax(taxMapper.requestDTOToEntity(productRequestDTO.getTax()));
        entity.setColor(productRequestDTO.getColor());
        entity.setCode(productRequestDTO.getCode());
        entity.setName(productRequestDTO.getName());
        entity.setQuantity(productRequestDTO.getQuantity());
        entity.setBuyPrice(productRequestDTO.getBuyPrice());
        entity.setSellPrice(productRequestDTO.getSellPrice());
        return entity;
    }

    @Override
    public PageDTO<ProductDTO> pageEntityToPageDTO(Page<ProductEntity> entityPage) {
        PageDTO<ProductDTO> dtoPage = new PageDTO<>();
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
