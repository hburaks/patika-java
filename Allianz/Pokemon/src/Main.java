import model.Battle;
import model.Character;
import model.Player;
import model.Pokemon;
import service.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        BattleService battleService = new BattleService();
        PokemonService pokemonService = new PokemonService();

        ArrayList<Character> characterList = loadService.loadCharacters();
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();


        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("------ PLAYER 1 ------");
        playerService.setPlayerName(player1);
        playerService.addCharacterToPlayer(player1, characterList);
        playerService.addPokemonToPlayer(player1, pokemonList);

        System.out.println("------ PLAYER 2 ------");
        playerService.setPlayerName(player2);
        playerService.addCharacterToPlayer(player2, characterList);
        playerService.addPokemonToPlayer(player2, pokemonList);

        while (true) {
            System.out.println("1 - Battle");
            System.out.println("2 - Exit");
            System.out.print("Select your move:");
            int move = inp.nextInt();
            if (move == 1) {
                Battle battle1 = battleService.startBattle(player1, player2);
                Pokemon weakestPokemon = pokemonService.findWeakestPokemon(pokemonList);
                if (player1.getCharacter().getPokemonList().size() == 0) {
                    player1.getCharacter().getPokemonList().add(weakestPokemon);
                } else if (player2.getCharacter().getPokemonList().size() == 0) {
                    player2.getCharacter().getPokemonList().add(weakestPokemon);
                }
                Battle battle2 = battleService.startBattle(player1, player2);
                System.out.println("First round's winner is " +
                        battle1.getWinner().getName() +
                        " and the second round's winner is " +
                        battle2.getWinner().getName());
                break;
            } else if (move == 2) {
                break;
            }
        }

    }

}

