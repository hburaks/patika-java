package com.allianz.example230821.database.entity;

import com.allianz.example230821.util.dbutil.BaseEntity;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity person;

}
