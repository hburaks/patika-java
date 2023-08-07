package com.allianz.instructorExample.database.entity;

import com.allianz.instructorExample.util.dbutil.BaseEntity;
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

    @Column(unique = true,length = 1250)
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column
    private String tc;


    @OneToMany(mappedBy = "person",fetch = FetchType.EAGER)
    private List<AddressEntity> addressEntityList;


}
