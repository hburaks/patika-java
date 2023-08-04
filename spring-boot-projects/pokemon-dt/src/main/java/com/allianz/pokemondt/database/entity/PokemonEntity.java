package com.allianz.pokemondt.database.entity;

import com.allianz.pokemondt.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class PokemonEntity extends BaseEntity {
    @Column
    String name;
    @Column
    int power;
    @Enumerated(EnumType.STRING)
    PokemonTypeEnum pokemonTypeEnum;
}
