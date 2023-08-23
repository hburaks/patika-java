package com.allianz.example230821.database.entity;

import com.allianz.example230821.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table
public class OrderItemEntity extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity product;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal sellPrice;

}
