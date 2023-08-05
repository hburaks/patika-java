package com.allianz.erp.service;

import com.allianz.erp.database.entity.Customer;
import com.allianz.erp.database.entity.CustomerOrder;
import com.allianz.erp.database.entity.OrderItem;
import com.allianz.erp.database.entity.Product;
import com.allianz.erp.database.repository.CustomerOrderRepository;
import com.allianz.erp.database.repository.OrderItemRepository;
import com.allianz.erp.model.OrderItemStatusTypeEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderService {
    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrderItemRepository orderItemRepository;


    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getReferenceById(id);
    }


    public CustomerOrder addOrderItemToCustomerOrder(OrderItem orderItem, CustomerOrder customerOrder) {
        if (customerOrder.getOrderItemList() == null) {
            customerOrder.setOrderItemList(new ArrayList<OrderItem>());
        }
        customerOrder.getOrderItemList().add(orderItem);
        return customerOrder;
    }

    public CustomerOrder addOrderItemToCustomerOrderWithId(OrderItem orderItem, Long customerOrderId) {
        CustomerOrder customerOrder = getCustomerOrderById(customerOrderId);
        addOrderItemToCustomerOrder(orderItem, customerOrder);
        return customerOrder;
    }

    public boolean removeOrderItemFromCustomerOrderWithId(Long orderItemId, Long customerOrderId) {
        CustomerOrder customerOrder = getCustomerOrderById(customerOrderId);
        for (int i = 0; i < customerOrder.getOrderItemList().size(); i++) {
            if (customerOrder.getOrderItemList().get(i).getId().equals(orderItemId)) {
                customerOrder.getOrderItemList().remove(i);
                return true;
            }
        }
        return false;
    }

    public CustomerOrder createCustomerOrder(Customer customer) {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        return customerOrder;
    }

    public boolean removeCustomerOrderWithId(Long customerOrderId) {
        CustomerOrder customerOrder = customerOrderRepository.getReferenceById(customerOrderId);
        if (customerOrder != null) {
            customerOrderRepository.delete(customerOrder);
            return true;
        }
        return false;
    }

    @Transactional
    public CustomerOrder approveOrdersStatusIfPossible(CustomerOrder customerOrder) {
        List<OrderItem> updatedOrders = customerOrder.getOrderItemList();
        for (OrderItem orderItem : updatedOrders) {
            Product stockUpdatedProduct = productService.getProductById(orderItem.getProduct().getId());
            if (orderItem.getQuantity() <= stockUpdatedProduct.getStock()) {
                orderItem.setOrderItemStatusTypeEnum(OrderItemStatusTypeEnum.APPROVED);
                productService.updateProductStock(
                        stockUpdatedProduct.getStock() - orderItem.getQuantity(),
                        stockUpdatedProduct
                );
                orderItemRepository.save(orderItem);
            } else {
                orderItem.setOrderItemStatusTypeEnum(OrderItemStatusTypeEnum.CANCELLED);
            }
        }
        customerOrder.setOrderItemList(updatedOrders);
        return customerOrder;
    }
}
