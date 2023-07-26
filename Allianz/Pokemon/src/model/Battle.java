package model;

import service.PokemonService;
import service.WeatherService;

public class Battle {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private WeatherTypeEnum weatherType;
    private Pokemon winner;

    public Battle(Pokemon pokemon1,Pokemon pokemon2) {
        WeatherService weatherService = new WeatherService();
        PokemonService pokemonService = new PokemonService();

        WeatherTypeEnum weatherType =  weatherService.createWeather();

        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.weatherType = weatherType;

        pokemonService.decreaseSpecialPowerAccordingToWeather(pokemon1,weatherType);
        pokemonService.decreaseSpecialPowerAccordingToWeather(pokemon2,weatherType);
    }

    // TODO: reset special power after fight in battle service
}
