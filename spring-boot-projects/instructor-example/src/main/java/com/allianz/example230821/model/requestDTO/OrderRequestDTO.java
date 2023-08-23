package com.allianz.example230821.model.requestDTO;

import com.allianz.example230821.model.enums.OrderStatusEnum;
import com.allianz.example230821.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO extends BaseDTO {

    private CustomerRequestDTO customer;
    private OrderStatusEnum orderStatus;
    private List<OrderItemRequestDTO> orderItemList;
    private BigDecimal totalSellPrice;
}
