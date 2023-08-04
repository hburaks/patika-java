package com.allianz.erp.database.entity;

import com.allianz.erp.model.OrderItemStatusTypeEnum;
import com.allianz.erp.util.dbutil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Table
@Entity
@Data
public class OrderItem extends BaseEntity {
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @Column
    private OrderItemStatusTypeEnum orderItemStatusTypeEnum;

    @Column
    private int quantity;

    @Column
    private BigDecimal price;

    @Column
    BigDecimal taxAmount;

}
