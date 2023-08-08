package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class SellerEntity extends BaseEntity {

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String tc;
    @Column
    private String email;
    @Column
    private String shopName;
    @Column
    private String taxNumber;
    @Column
    private String taxOffice;











}
