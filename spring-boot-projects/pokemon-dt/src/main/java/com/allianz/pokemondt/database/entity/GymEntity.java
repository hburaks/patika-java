package com.allianz.pokemondt.database.entity;

import com.allianz.pokemondt.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class GymEntity extends BaseEntity {
    @Column
    String name;
    @Column
    int establishDate;
    @Column
    int qualityStar;
}
