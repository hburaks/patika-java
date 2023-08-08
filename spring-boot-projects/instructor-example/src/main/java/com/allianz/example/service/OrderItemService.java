package com.allianz.example.service;

import com.allianz.erp.entity.CustomerOrder;
import com.allianz.erp.entity.OrderItem;
import com.allianz.erp.entity.Product;
import com.allianz.erp.model.OrderItemStatusTypeEnum;
import com.allianz.erp.repository.OrderItemRepository;
import com.allianz.erp.util.config.ConfigService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    ConfigService configService;
    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(Long productId, Long customerId, int quantity) {
        Product product = productService.getProductById(productId);
        CustomerOrder customerOrder = orderService.getCustomerOrderById(customerId);

        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Insufficient stock for the product: " + product.getName());
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setName(product.getName());
        orderItem.setProduct(product);
        orderItem.setCustomerOrder(customerOrder);
        orderItem.setOrderItemStatusTypeEnum(OrderItemStatusTypeEnum.PENDING);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(product.getPrice());
        orderItem.setTaxAmount(configService.calculateTaxAmount(product.getPrice()));
        productService.updateProductStock(quantity, product);
        return orderItem;
    }

    public List<OrderItem> getOrderItemsApproved(List<OrderItem> orderItemList) {
        List<OrderItem> orderItemsApproved = null;
        for (OrderItem orderItem : orderItemList) {
            if (orderItem.getOrderItemStatusTypeEnum().equals(OrderItemStatusTypeEnum.APPROVED)) {
                orderItemsApproved.add(orderItem);
            }
        }
        return orderItemsApproved;
    }

    public BigDecimal getTotalPrice(List<OrderItem> orderItemList) {
        BigDecimal totalPrice = null;
        for (OrderItem orderItem : orderItemList) {
            totalPrice.add(orderItem.getPrice());
        }
        return totalPrice;
    }

    public BigDecimal getTotalTax(List<OrderItem> orderItemList) {
        BigDecimal totalTax = null;
        for (OrderItem orderItem : orderItemList) {
            totalTax.add(orderItem.getTaxAmount());
        }
        return totalTax;
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.getReferenceById(id);
    }

    @Transactional
    public OrderItem updateOrderItemQuantity(Long id, int quantity) {
        OrderItem orderItem = getOrderItemById(id);
        orderItem.setQuantity(quantity);
        return orderItem;
    }

    @Transactional
    public OrderItem updateOrderItemStatus(Long id, OrderItemStatusTypeEnum orderItemStatusTypeEnum) {
        OrderItem orderItem = getOrderItemById(id);
        orderItem.setOrderItemStatusTypeEnum(orderItemStatusTypeEnum);
        return orderItem;
    }


}
