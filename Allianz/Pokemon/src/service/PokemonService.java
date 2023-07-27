package service;

import model.Pokemon;
import model.WeatherTypeEnum;

import java.util.ArrayList;

public class PokemonService {
    public void decreaseSpecialPowerAccordingToWeather(Pokemon pokemon, WeatherTypeEnum weatherType) {
        if(pokemon.getType() == weatherType.getCorrespondingPowerType()){
            pokemon.getSpecialPower().setExtraDamage(0);
        }
    }
    public void resetSpecialPower(Pokemon pokemon) {
        pokemon.getSpecialPower().setExtraDamage(pokemon.getSpecialPower().getOriginalExtraDamage());
    }

    public Pokemon findWeakestPokemon(ArrayList<Pokemon> pokemonList) {
        Pokemon weakestPokemon = pokemonList.get(0);
        for(Pokemon pokemon : pokemonList){
            if(pokemon.getDamage() < weakestPokemon.getDamage()){
                weakestPokemon = pokemon;
            }
        }
        return weakestPokemon;
    }
}
