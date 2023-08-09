package com.allianz.example.service;


import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.database.repository.OrderRepository;
import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends BaseService<OrderEntity> {
    @Autowired
    OrderRepository customerOrderRepository;

    @Autowired
    ProductService productService;
    @Autowired
    OrderItemRepository orderItemRepository;




    public OrderEntity addOrderItemToCustomerOrder(OrderItemEntity orderItem, OrderEntity customerOrder) {
        if (customerOrder.getOrderItemEntityList() == null) {
            customerOrder.setOrderItemEntityList(new ArrayList<OrderItemEntity>());
        }
        customerOrder.getOrderItemEntityList().add(orderItem);
        return customerOrder;
    }

    public OrderEntity addOrderItemToCustomerOrderWithId(OrderItemEntity orderItem, Long customerOrderId) throws Exception {
        Optional<OrderEntity> customerOrderOptional = findById(customerOrderId);

        if (customerOrderOptional.isPresent()) {
            OrderEntity customerOrder = customerOrderOptional.get();
            addOrderItemToCustomerOrder(orderItem, customerOrder);
            return customerOrder;
        } else {
            throw new Exception("Customer order with ID " + customerOrderId + " not found.");
        }
    }

    public boolean removeOrderItemFromOrderEntityWithId(Long orderItemId, Long customerOrderId) throws Exception {
        Optional<OrderEntity> customerOrderOptional = findById(customerOrderId);

        if (customerOrderOptional.isPresent()) {
            OrderEntity customerOrder = customerOrderOptional.get();
            for (int i = 0; i < customerOrder.getOrderItemEntityList().size(); i++) {
            if (customerOrder.getOrderItemEntityList().get(i).getId().equals(orderItemId)) {
                customerOrder.getOrderItemEntityList().remove(i);
                return true;
            }
        }}
        return false;
    }


    public OrderEntity createOrderEntity(CustomerEntity customer) {
        OrderEntity customerOrder = new OrderEntity();
        customerOrder.setCustomer(customer);
        return customerOrder;
    }

    public boolean removeOrderEntityWithId(Long customerOrderId) {
        OrderEntity customerOrder = customerOrderRepository.getReferenceById(customerOrderId);
        if (customerOrder != null) {
            customerOrderRepository.delete(customerOrder);
            return true;
        }
        return false;
    }


    @Transactional
    public OrderEntity approveOrdersStatusIfPossible(OrderEntity customerOrder) throws Exception {
        List<OrderItemEntity> updatedOrders = new ArrayList<>();

        for (OrderItemEntity orderItem : customerOrder.getOrderItemEntityList()) {
            Optional<ProductEntity> stockUpdatedProductOptional = productService.findById(orderItem.getProduct().getId());

            if (stockUpdatedProductOptional.isPresent()) {
                ProductEntity stockUpdatedProduct = stockUpdatedProductOptional.get();

                if (orderItem.getQuantity() <= stockUpdatedProduct.getQuantity()) {
                    orderItem.setOrderStatus(OrderStatusEnum.APPROVED);
                    int newStockQuantity = stockUpdatedProduct.getQuantity() - orderItem.getQuantity();
                    stockUpdatedProduct.setQuantity(newStockQuantity);
                    productService.updateProductStock(newStockQuantity, stockUpdatedProduct);
                    orderItemRepository.save(orderItem);
                } else {
                    orderItem.setOrderStatus(OrderStatusEnum.CANCELED);
                }

                updatedOrders.add(orderItem);
            }
        }

        customerOrder.setOrderItemEntityList(updatedOrders);
        return customerOrder;
    }

}
