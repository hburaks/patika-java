package com.allianz.example.database.entity;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table
public class OrderItemEntity extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal sellPrice;

}
