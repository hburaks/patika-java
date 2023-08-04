package com.allianz.erp.database.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Data
@Table
@Entity
public class Product extends BaseEntity {

    @Column
    private String name;

    @Column
    private String info;

    @Column
    private int stock;

    @Column
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItemList;

    @Column
    private boolean isProductAvailable;

    @Column
    private BigDecimal taxAppliedPrice;


    // TODO: throw exception if the tax ratio is bigger than 1;
    // TODO: Get ile alırken kdv ye göre fiyatı güncelle

}
