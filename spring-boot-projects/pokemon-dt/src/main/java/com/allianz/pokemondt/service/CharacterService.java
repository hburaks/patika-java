package com.allianz.pokemondt.service;

import com.allianz.pokemondt.database.entity.CharacterEntity;
import com.allianz.pokemondt.database.entity.PokemonTypeEnum;
import com.allianz.pokemondt.database.repository.CharacterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    CharacterEntityRepository characterEntityRepository;

    public List<CharacterEntity> getCharacterEntities() {
        return characterEntityRepository.findAll();
    }

    public CharacterEntity getCharacterByName(String name) {
        CharacterEntity characterEntity = characterEntityRepository.getCharacterEntityByName(name);
        return characterEntity;
    }

    public List<CharacterEntity> getCharacterByType(PokemonTypeEnum pokemonTypeEnum) {
        List<CharacterEntity> characterEntities = characterEntityRepository.getCharacterEntitiesByPokemonTypeEnum(pokemonTypeEnum);
        return characterEntities;
    }

    public CharacterEntity createCharacter(String name, int age, PokemonTypeEnum pokemonTypeEnum) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(name);
        characterEntity.setAge(age);
        characterEntity.setPokemonTypeEnum(pokemonTypeEnum);

        characterEntityRepository.save(characterEntity);

        return characterEntity;
    }
}
