import model.Character;
import model.Player;
import model.Pokemon;
import service.LoadService;
import service.PlayerService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*Scanner inp = new Scanner(System.in);

        GameService gameService = new GameService();





        characterList.get(0).getPokemonList().add(pokemonList.get(0));
        characterList.get(1).getPokemonList().add(pokemonList.get(1));

        Player player1 = playerService.createPlayer("Tuğçe", characterList.get(0));
        Player player2 = playerService.createPlayer("Hasan", characterList.get(1));

        gameService.attack(player1, player2, true, true);

        gameService.healthCheck(player2);
        */
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();



        ArrayList<Character> characterList = loadService.loadCharacters();
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();


        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("------ PLAYER 1 ------");
        playerService.setPlayerName(player1);
        playerService.addCharacterToPlayer(player1, characterList);
        playerService.addPokemonToPlayer(player1,pokemonList);

        System.out.println("------ PLAYER 2 ------");
        playerService.setPlayerName(player2);
        playerService.addCharacterToPlayer(player2, characterList);
        playerService.addPokemonToPlayer(player2,pokemonList);











    }

}