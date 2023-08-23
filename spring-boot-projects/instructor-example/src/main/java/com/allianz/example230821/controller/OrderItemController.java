package com.allianz.example230821.controller;

import com.allianz.example230821.database.entity.OrderItemEntity;
import com.allianz.example230821.database.repository.OrderItemEntityRepository;
import com.allianz.example230821.database.specification.OrderItemSpecification;
import com.allianz.example230821.mapper.OrderItemMapper;
import com.allianz.example230821.model.OrderItemDTO;
import com.allianz.example230821.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example230821.service.OrderItemService;
import com.allianz.example230821.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-item")
public class OrderItemController extends BaseController<
        OrderItemEntity,
        OrderItemDTO,
        OrderItemRequestDTO,
        OrderItemMapper,
        OrderItemEntityRepository,
        OrderItemSpecification,
        OrderItemService> {

    @Autowired
    OrderItemService orderItemService;

    @Override
    protected OrderItemService getService() {
        return this.orderItemService;
    }
}