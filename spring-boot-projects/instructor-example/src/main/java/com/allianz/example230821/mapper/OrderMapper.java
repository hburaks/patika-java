package com.allianz.example230821.mapper;

import com.allianz.example230821.database.entity.OrderEntity;
import com.allianz.example230821.model.OrderDTO;
import com.allianz.example230821.model.requestDTO.OrderRequestDTO;
import com.allianz.example230821.model.requestDTO.PageDTO;
import com.allianz.example230821.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Autowired
    @Lazy
    CustomerMapper customerMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {

        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        dto.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setOrderItemList(orderItemMapper.entityListToDTOList(entity.getOrderItemList()));
        dto.setTotalSellPrice(entity.getTotalSellPrice());

        return dto;


    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        return entity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        return null;
    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {
        return null;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderItemList(orderItemMapper.requestDtoListTOEntityList(dto.getOrderItemList()));
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        return entity;
    }

    @Override
    public List<OrderEntity> requestDtoListTOEntityList(List<OrderRequestDTO> orderRequestDTOS) {
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for (OrderRequestDTO orderRequestDTO : orderRequestDTOS) {
            orderEntityList.add(requestDTOToEntity(orderRequestDTO));
        }
        return orderEntityList;
    }

    @Override
    public OrderEntity requestDtoToExistEntity(OrderEntity entity, OrderRequestDTO orderRequestDTO) {
        entity.setCustomer(customerMapper.requestDTOToEntity(orderRequestDTO.getCustomer()));
        entity.setOrderItemList(orderItemMapper.requestDtoListTOEntityList(orderRequestDTO.getOrderItemList()));
        entity.setOrderStatus(orderRequestDTO.getOrderStatus());
        entity.setTotalSellPrice(orderRequestDTO.getTotalSellPrice());
        return entity;
    }

    @Override
    public PageDTO<OrderDTO> pageEntityToPageDTO(Page<OrderEntity> entityPage) {
        PageDTO<OrderDTO> dtoPage = new PageDTO<>();
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
