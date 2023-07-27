package service;


import model.Character;
import model.Player;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerService {
    Scanner inp = new Scanner(System.in);

    public Player createPlayer(String name, Character character) {
        return new Player(name, character);
    }


    public void setPlayerName(Player player) {
        while (player.getName() == null) {
            System.out.print("Enter the player name: ");
            String playerName = inp.next(); // Read a single word (string) from the user
            if (!playerName.trim().isEmpty()) {
                player.setName(playerName);
            }
        }
    }


    public void addCharacterToPlayer(Player player, ArrayList<Character> characterList) {
        System.out.println("------ Characters ------");
        int n = 1;
        for (Character character : characterList) {
            System.out.println(n + "- " + character.getName());
            n++;
        }
        while (player.getCharacter() == null) {
            System.out.print("Select the character: ");
            int characterIndex = inp.nextInt() - 1;
            if (characterIndex > -1 && characterIndex < characterList.size()) {
                player.setCharacter(characterList.get(characterIndex));
                characterList.remove(characterIndex);
            }
        }
    }


    public void addPokemonToPlayer(Player player, ArrayList<Pokemon> pokemonList) {
        if(player.getCharacter().getPokemonList() == null){
            player.getCharacter().setPokemonList(new ArrayList<Pokemon>());
        }
        System.out.println("------ Pokemons ------");
        int n = 1;
        for (Pokemon pokemon : pokemonList) {
            System.out.println(n + "- " + pokemon.getName());
            n++;
        }
        boolean flag = true;
        while (flag) {
            System.out.print("Select the pokemon: ");
            int pokemonIndex = inp.nextInt() - 1;
            if (pokemonIndex > -1 && pokemonIndex < pokemonList.size()) {
                player.getCharacter().getPokemonList().add(pokemonList.get(pokemonIndex));
                System.out.println(pokemonList.get(pokemonIndex).getName() + " added to " + player.getCharacter().getName());
                pokemonList.remove(pokemonIndex);
                flag = false;
            }
        }
    }
}
