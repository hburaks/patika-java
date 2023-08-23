package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.OrderEntity;
import com.allianz.example230821.database.repository.OrderEntityRepository;
import com.allianz.example230821.database.specification.OrderSpecification;
import com.allianz.example230821.mapper.OrderMapper;
import com.allianz.example230821.model.OrderDTO;
import com.allianz.example230821.model.requestDTO.OrderRequestDTO;
import com.allianz.example230821.service.OrderService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController<
        OrderEntity,
        OrderDTO,
        OrderRequestDTO,
        OrderMapper,
        OrderEntityRepository,
        OrderSpecification,
        OrderService> {

    @Autowired
    OrderService orderService;

    @Override
    protected OrderService getService() {
        return this.orderService;
    }
}