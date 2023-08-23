package com.allianz.example230821.model;

import com.allianz.example230821.model.enums.OrderStatusEnum;
import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO extends BaseDTO {

    private CustomerDTO customer;
    private OrderStatusEnum orderStatus;
    private List<OrderItemDTO> orderItemList;
    private BigDecimal totalSellPrice;
}
