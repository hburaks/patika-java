package com.allianz.example230821.service;

import com.allianz.example230821.database.entity.OrderEntity;
import com.allianz.example230821.database.repository.OrderEntityRepository;
import com.allianz.example230821.database.specification.OrderSpecification;
import com.allianz.example230821.mapper.OrderMapper;
import com.allianz.example230821.model.OrderDTO;
import com.allianz.example230821.model.requestDTO.OrderRequestDTO;
import com.allianz.example230821.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDTO, OrderRequestDTO,
        OrderMapper, OrderEntityRepository, OrderSpecification> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderSpecification orderSpecification;
    @Override
    protected OrderMapper getMapper() {
        return this.orderMapper;
    }

    @Override
    protected OrderEntityRepository getRepository() {
        return this.orderEntityRepository;
    }

    @Override
    protected OrderSpecification getSpecification() {
        return orderSpecification;
    }
}
