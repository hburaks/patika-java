package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.BillEntity;
import com.allianz.example230821.model.BillDTO;
import com.allianz.example230821.model.requestDTO.BillRequestDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    //@Lazy
    OrderMapper orderMapper;

    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO dto = new BillDTO();
        dto.setBillDate(entity.getBillDate());
        dto.setBillNo(entity.getBillNo());
        dto.setTaxRate(entity.getTaxRate());
        dto.setTaxAmount(entity.getTaxAmount());
        dto.setTotalSellPrice(entity.getTotalSellPrice());
        dto.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        dto.setOrder(orderMapper.entityToDTO(entity.getOrder()));

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    @Override
    public BillEntity dtoToEntity(BillDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setBillDate(dto.getBillDate());
        entity.setBillNo(dto.getBillNo());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {
        List<BillDTO> dtoList = new ArrayList<>();
        for (BillEntity entity : billEntities) {
            BillDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public List<BillEntity> dtoListTOEntityList(List<BillDTO> billDTOS) {
        List<BillEntity> entityList = new ArrayList<>();
        for (BillDTO dto : billDTOS) {
            BillEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }

        return entityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setBillDate(dto.getBillDate());
        entity.setBillNo(dto.getBillNo());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setOrder(orderMapper.requestDTOToEntity(dto.getOrder()));

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public List<BillEntity> requestDtoListTOEntityList(List<BillRequestDTO> billRequestDTOS) {
        return null;
    }

    @Override
    public BillEntity requestDtoToExistEntity(BillEntity entity, BillRequestDTO billRequestDTO) {
        entity.setOrder(orderMapper.requestDTOToEntity(billRequestDTO.getOrder()));
        entity.setBillNo(billRequestDTO.getBillNo());
        entity.setBillDate(billRequestDTO.getBillDate());
        entity.setTaxAmount(billRequestDTO.getTaxAmount());
        entity.setTaxRate(billRequestDTO.getTaxRate());
        entity.setTotalSellNetPrice(billRequestDTO.getTotalSellNetPrice());
        entity.setTotalSellPrice(billRequestDTO.getTotalSellPrice());
        return entity;
    }

    @Override
    public PageDTO<BillDTO> pageEntityToPageDTO(Page<BillEntity> entityPage) {
        PageDTO<BillDTO> dtoPage = new PageDTO<>();
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
