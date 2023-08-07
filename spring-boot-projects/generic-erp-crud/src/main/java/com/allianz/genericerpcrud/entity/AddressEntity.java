package com.allianz.genericerpcrud.entity;

import com.allianz.genericerpcrud.entity.generic.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "address_uuid"
        )
)
@Data
public class AddressEntity extends BaseEntity {

    @Column
    private String title;

    @Column(length = 500)
    private String address;

  //  @ManyToOne(fetch = FetchType.LAZY)
 //   private PersonEntity person;

}
