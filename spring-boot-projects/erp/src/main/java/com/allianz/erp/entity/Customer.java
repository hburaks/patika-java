package com.allianz.erp.entity;

import com.allianz.erp.util.dbutil.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Data
public class Customer extends BaseEntity {

    @Column
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrderList;

    @OneToMany(mappedBy = "customer")
    private List<Bill> billList;

}
