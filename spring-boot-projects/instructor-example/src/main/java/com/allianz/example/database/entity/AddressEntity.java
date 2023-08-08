package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "address_uuid"
        )
)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AddressEntity extends BaseEntity {

    @Column
    private String title;

    @Column(length = 500)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity person;


}
