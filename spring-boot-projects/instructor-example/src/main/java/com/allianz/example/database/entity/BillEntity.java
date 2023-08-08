package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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





}
