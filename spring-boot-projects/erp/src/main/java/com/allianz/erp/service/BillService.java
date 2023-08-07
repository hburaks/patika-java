package com.allianz.erp.service;

import com.allianz.erp.entity.Bill;
import com.allianz.erp.entity.CustomerOrder;
import com.allianz.erp.entity.OrderItem;
import com.allianz.erp.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    @Autowired
    CustomerOrderService customerOrderService;

    @Autowired
    OrderItemService orderItemService;

    public Bill createBillWithApprovedOrderItems(CustomerOrder customerOrder) {
        List<OrderItem> orderItemsApproved = orderItemService.getOrderItemsApproved(customerOrder.getOrderItemList());
        Bill bill = new Bill();

        bill.setCustomer(customerOrder.getCustomer());
        bill.setOrderItemList(orderItemsApproved);
        bill.setTotalPrice(orderItemService.getTotalPrice(orderItemsApproved));
        bill.setTotalTaxAmount(orderItemService.getTotalTax(orderItemsApproved));
        return bill;
    }

    public Bill getBillById(Long billId) {
       return billRepository.getReferenceById(billId);
    }
}
