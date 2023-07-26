package service;

import model.Pokemon;
import model.WeatherTypeEnum;

public class PokemonService {
    public void decreaseSpecialPowerAccordingToWeather(Pokemon pokemon, WeatherTypeEnum weatherType) {
        if(pokemon.getType() == weatherType.getCorrespondingPowerType()){
            pokemon.getSpecialPower().setExtraDamage(0);
        }
    }
    public void resetSpecialPower(Pokemon pokemon) {
        pokemon.getSpecialPower().setExtraDamage(pokemon.getSpecialPower().getOriginalExtraDamage());
    }
}
