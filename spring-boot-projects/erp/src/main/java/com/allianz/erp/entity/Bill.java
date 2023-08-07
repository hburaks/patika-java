package com.allianz.erp.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table
@Entity
@Data
public class Bill extends BaseEntity {


    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private List<OrderItem> orderItemList;

    @Column
    private BigDecimal totalPrice;

    @Column
    private BigDecimal totalTaxAmount;

}
