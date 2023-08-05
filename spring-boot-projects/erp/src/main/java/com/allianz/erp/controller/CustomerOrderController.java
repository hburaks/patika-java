package com.allianz.erp.controller;

import com.allianz.erp.database.entity.CustomerOrder;
import com.allianz.erp.database.entity.OrderItem;
import com.allianz.erp.service.CustomerOrderService;
import com.allianz.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer-order")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    @Autowired
    CustomerService customerService;

    @GetMapping("{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(customerOrderService.getCustomerOrderById(id), HttpStatus.OK);
    }


    @PostMapping("/customer-id/{customerId}")
    public ResponseEntity<CustomerOrder> createCustomerOrderWithCustomerId(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerOrderService.createCustomerOrder(customerService.getCustomerById(customerId)), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderItem> addOrderItemToCustomerOrderWithId(@RequestBody OrderItem orderItem, @PathVariable Long id) {
        customerOrderService.addOrderItemToCustomerOrderWithId(orderItem,id);
        return new ResponseEntity<>(orderItem,HttpStatus.OK);
    }

    @DeleteMapping("{customerOrderId}/order-item/id/{orderItemId}")
    public ResponseEntity<String> removeOrderItemFromCustomerOrder(@PathVariable Long orderItemId, @PathVariable Long customerOrderId) {
        boolean removed = customerOrderService.removeOrderItemFromCustomerOrderWithId(orderItemId, customerOrderId);
        if (removed) {
            return new ResponseEntity<>("Product removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{customerOrderId}")
    public ResponseEntity<String> removeCustomerOrder(@PathVariable Long customerOrderId) {
        boolean removed = customerOrderService.removeCustomerOrderWithId(customerOrderId);
        if (removed) {
            return new ResponseEntity<>("Customer order removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer order not found", HttpStatus.NOT_FOUND);
        }
    }



}
