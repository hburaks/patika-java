package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
public class BillEntity extends BaseEntity {

    @Column(unique = true)
    private String billNo;

    @Column
    private LocalDateTime billDate;

    @Column
    private BigDecimal taxRate;

    @Column
    private BigDecimal taxAmount;

    @Column
    private BigDecimal totalSellNetPrice;

    @Column
    private BigDecimal totalSellPrice;

    @OneToOne
    private OrderEntity order;

    @OneToMany(mappedBy = "billEntity", fetch = FetchType.LAZY)
    private List<OrderItemEntity> orderItemEntityList;





}
