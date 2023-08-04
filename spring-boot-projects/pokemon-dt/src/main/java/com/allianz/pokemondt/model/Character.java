package com.allianz.pokemondt.model;

import com.allianz.pokemondt.database.entity.PokemonTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Character {
    String name;
    int age;
    PokemonTypeEnum pokemonTypeEnum;
}
