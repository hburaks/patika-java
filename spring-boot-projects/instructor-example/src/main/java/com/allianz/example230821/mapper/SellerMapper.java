package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.SellerEntity;
import com.allianz.example230821.model.SellerDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.model.requestDTO.SellerRequestDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper implements IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {
    @Override
    public SellerDTO entityToDTO(SellerEntity entity) {
        SellerDTO dto = new SellerDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setTc(entity.getTc());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setShopName(entity.getShopName());
        dto.setTaxNumber(entity.getTaxNumber());
        dto.setTaxOffice(entity.getTaxOffice());

        return dto;
    }

    @Override
    public SellerEntity dtoToEntity(SellerDTO dto) {
        SellerEntity entity = new SellerEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTc(dto.getTc());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setShopName(dto.getShopName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());

        return entity;
    }

    @Override
    public List<SellerDTO> entityListToDTOList(List<SellerEntity> sellerEntities) {
        List<SellerDTO> dtoList = new ArrayList<>();
        for (SellerEntity entity : sellerEntities) {
            SellerDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<SellerEntity> dtoListTOEntityList(List<SellerDTO> sellerDTOS) {
        List<SellerEntity> sellerEntityList = new ArrayList<>();
        for (SellerDTO dto : sellerDTOS) {
            SellerEntity entity = dtoToEntity(dto);
            sellerEntityList.add(entity);
        }
        return sellerEntityList;
    }

    @Override
    public SellerEntity requestDTOToEntity(SellerRequestDTO dto) {
        SellerEntity entity = new SellerEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTc(dto.getTc());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setShopName(dto.getShopName());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());

        return entity;
    }

    @Override
    public List<SellerEntity> requestDtoListTOEntityList(List<SellerRequestDTO> sellerRequestDTOS) {
        return null;
    }

    @Override
    public SellerEntity requestDtoToExistEntity(SellerEntity entity, SellerRequestDTO sellerRequestDTO) {
        entity.setName(sellerRequestDTO.getName());
        entity.setSurname(sellerRequestDTO.getSurname());
        entity.setEmail(sellerRequestDTO.getEmail());
        entity.setTc(sellerRequestDTO.getTc());
        entity.setShopName(sellerRequestDTO.getShopName());
        entity.setTaxNumber(sellerRequestDTO.getTaxNumber());
        entity.setTaxOffice(sellerRequestDTO.getTaxOffice());

        return entity;
    }

    @Override
    public PageDTO<SellerDTO> pageEntityToPageDTO(Page<SellerEntity> entityPage) {
        PageDTO<SellerDTO> dtoPage = new PageDTO<>();
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
