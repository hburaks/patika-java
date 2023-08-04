package com.allianz.pokemondt.service;

import com.allianz.pokemondt.database.entity.CharacterEntity;
import com.allianz.pokemondt.database.entity.PokemonEntity;
import com.allianz.pokemondt.database.entity.PokemonTypeEnum;
import com.allianz.pokemondt.database.repository.CharacterEntityRepository;
import com.allianz.pokemondt.database.repository.PokemonEntityRepository;
import com.allianz.pokemondt.util.dbutil.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    @Autowired
    PokemonEntityRepository pokemonEntityRepository;

    @Autowired
    CharacterEntityRepository characterEntityRepository;

    public List<PokemonEntity> getPokemonEntities() {
        return pokemonEntityRepository.findAll();
    }

    public List<PokemonEntity> getPokemonByNameStartsWith(String name) {
        List<PokemonEntity> pokemonEntities = pokemonEntityRepository.getPokemonEntityByNameStartingWith(name);
        return pokemonEntities;
    }

    public List<PokemonEntity> getPokemonByType(PokemonTypeEnum pokemonTypeEnum) {
        List<PokemonEntity> pokemonEntities = pokemonEntityRepository.getPokemonEntityByPokemonTypeEnum(pokemonTypeEnum);
        return pokemonEntities;
    }

    public PokemonEntity createPokemon(String name, int power, PokemonTypeEnum pokemonTypeEnum) {
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(name);
        pokemonEntity.setPower(power);
        pokemonEntity.setPokemonTypeEnum(pokemonTypeEnum);

        pokemonEntityRepository.save(pokemonEntity);

        return pokemonEntity;
    }

    public PokemonEntity getPokemonByName(String name){
        return pokemonEntityRepository.getPokemonEntityByName(name);
    }


    public List<BaseEntity>  getCharacterAndPokemon(String characterName, String pokemonName){
        PokemonEntity pokemonEntity = pokemonEntityRepository.getPokemonEntityByName(pokemonName);
        CharacterEntity characterEntity = characterEntityRepository.getCharacterEntityByName(characterName);
        List<BaseEntity> characterEntityPokemonEntityList = new ArrayList<>();
        characterEntityPokemonEntityList.add(pokemonEntity);
        characterEntityPokemonEntityList.add(characterEntity);
        return characterEntityPokemonEntityList;
    }


}
