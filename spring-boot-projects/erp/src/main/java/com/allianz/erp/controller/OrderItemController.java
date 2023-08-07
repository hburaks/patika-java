package com.allianz.erp.controller;

import com.allianz.erp.entity.OrderItem;
import com.allianz.erp.model.OrderItemStatusTypeEnum;
import com.allianz.erp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order-item")
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;

    @GetMapping("{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        return new ResponseEntity<>(orderItemService.getOrderItemById(id), HttpStatus.OK);
    }

    @PostMapping("customer/{customerId}/product/{productId}/quantity/{quantity}")
    public ResponseEntity<OrderItem> createOrderItem(@PathVariable Long customerId, Long productId, int quantity){
        OrderItem orderItem = orderItemService.createOrderItem(customerId,productId,quantity);
        return new ResponseEntity<>(orderItem, HttpStatus.CREATED);

    }


    @PutMapping("{id}/quantity/{quantity}")
    public ResponseEntity<OrderItem> updateOrderItemQuantity(@PathVariable Long id, @PathVariable int quantity) {
        OrderItem orderItem = orderItemService.updateOrderItemQuantity(id, quantity);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    @PutMapping("{id}/quantity/{status}")
    public ResponseEntity<OrderItem> updateOrderItemQuantity(@PathVariable Long id, @PathVariable OrderItemStatusTypeEnum status) {
        OrderItem orderItem = orderItemService.updateOrderItemStatus(id, status);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }


}
