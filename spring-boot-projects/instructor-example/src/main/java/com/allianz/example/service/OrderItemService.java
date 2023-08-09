package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService extends BaseService<OrderItemEntity> {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderItemEntity createOrderItem(Long productId, Long customerId, int quantity) throws Exception {
        ProductEntity product = productService.getProductById(productId);
        Optional<OrderEntity> customerOrder = orderService.findById(customerId);

        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient stock for the product: " + product.getName());
        }

        OrderItemEntity orderItem = new OrderItemEntity();
        orderItem.setProduct(product);
        orderItem.setOrderStatus(OrderStatusEnum.WAITING);
        orderItem.setQuantity(quantity);
        orderItem.setSellPrice(product.getSellPrice());
        productService.updateProductStock(quantity, product);
        return orderItem;
    }

    public List<OrderItemEntity> getOrderItemsApproved(List<OrderItemEntity> orderItemList) {
        List<OrderItemEntity> orderItemsApproved = null;
        for (OrderItemEntity orderItem : orderItemList) {
            if (orderItem.getOrderStatus().equals(OrderStatusEnum.APPROVED)) {
                orderItemsApproved.add(orderItem);
            }
        }
        return orderItemsApproved;
    }

    public BigDecimal getTotalPrice(List<OrderItemEntity> orderItemList) {
        BigDecimal totalPrice = null;
        for (OrderItemEntity orderItem : orderItemList) {
            totalPrice.add(orderItem.getSellPrice());
        }
        return totalPrice;
    }

    public BigDecimal getTotalTax(List<OrderItemEntity> orderItemList) {
        BigDecimal totalTax = null;
        for (OrderItemEntity orderItem : orderItemList) {
            totalTax.add(orderItem.getProduct().getBuyPrice().subtract(orderItem.getProduct().getBuyPrice()));
        }
        return totalTax;
    }

    public OrderItemEntity getOrderItemById(Long id) {
        return orderItemRepository.getReferenceById(id);
    }

    @Transactional
    public OrderItemEntity updateOrderItemQuantity(Long id, int quantity) {
        OrderItemEntity orderItem = getOrderItemById(id);
        orderItem.setQuantity(quantity);
        return orderItem;
    }

    @Transactional
    public OrderItemEntity updateOrderItemStatus(Long id, OrderStatusEnum orderItemStatusTypeEnum) {
        OrderItemEntity orderItem = getOrderItemById(id);
        orderItem.setOrderStatus(orderItemStatusTypeEnum);
        return orderItem;
    }


}
