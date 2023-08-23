package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.OrderItemEntity;
import com.allianz.example230821.database.repository.OrderItemEntityRepository;
import com.allianz.example230821.database.specification.OrderItemSpecification;
import com.allianz.example230821.mapper.OrderItemMapper;
import com.allianz.example230821.model.OrderItemDTO;
import com.allianz.example230821.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO, OrderItemRequestDTO,
        OrderItemMapper, OrderItemEntityRepository, OrderItemSpecification> {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    protected OrderItemMapper getMapper() {
        return this.orderItemMapper;
    }

    @Override
    protected OrderItemEntityRepository getRepository() {
        return this.orderItemEntityRepository;
    }

    @Override
    protected OrderItemSpecification getSpecification() {
        return null;
    }
}
