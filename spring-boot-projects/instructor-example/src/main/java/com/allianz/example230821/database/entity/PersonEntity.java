package com.allianz.example230821.database.entity;

import com.allianz.example230821.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "person_uuid"
        )
)
@Data
public class PersonEntity extends BaseEntity {

    @Column(unique = true, length = 1250)
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column(unique = true)
    private String tc;

    @Column(unique = true)
    private String mail;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<AddressEntity> addressEntityList;


}
