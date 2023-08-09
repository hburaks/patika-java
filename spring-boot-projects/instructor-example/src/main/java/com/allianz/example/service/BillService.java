package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    public BillEntity createBillWithApprovedOrderItems(OrderEntity customerOrder) {
        List<OrderItemEntity> orderItemsApproved = orderItemService.getOrderItemsApproved(customerOrder.getOrderItemEntityList());


        BillEntity bill = new BillEntity();

//        bill.setCustomer(customerOrder.getCustomer());
        bill.setOrderItemEntityList(orderItemsApproved);
        bill.setTotalSellPrice(orderItemService.getTotalPrice(orderItemsApproved));
        bill.setTaxAmount(orderItemService.getTotalTax(orderItemsApproved));
        return bill;
    }

}
