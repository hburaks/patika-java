package com.allianz.pokemondt.database.repository;

import com.allianz.pokemondt.database.entity.CharacterEntity;
import com.allianz.pokemondt.database.entity.PokemonTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {
    public CharacterEntity getCharacterEntityByName(String name);
    public List<CharacterEntity> getCharacterEntitiesByPokemonTypeEnum(PokemonTypeEnum pokemonTypeEnum);
}
