package service;

import Helper.Helper;
import model.Battle;
import model.Player;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleService {
    Scanner inp = new Scanner(System.in);

    public Battle createBattle(Player player1, Player player2) {
        System.out.println("------ " + player1.getName() + " ------");
        Pokemon pokemon1 = selectPokemonToFight(player1.getCharacter().getPokemonList());

        System.out.println("------ " + player2.getName() + " ------");

        Pokemon pokemon2 = selectPokemonToFight(player2.getCharacter().getPokemonList());

        return new Battle(pokemon1, pokemon2);
    }

    public Pokemon selectPokemonToFight(ArrayList<Pokemon> pokemonList) {
        Pokemon selectedPokemon = null;
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
                System.out.println(pokemonList.get(pokemonIndex).getName() + " selected for battle");
                flag = false;
                selectedPokemon = pokemonList.get(pokemonIndex);
                pokemonList.remove(pokemonIndex);
            }
        }
        return selectedPokemon;
    }

    public Battle startBattle(Player player1, Player player2) {
        GameService gameService = new GameService();

        Player firstPlayer = player1;
        Player secondPlayer = player2;

        int firstPlayerToAttack = Helper.createRandomNum(1, 2);
        if (firstPlayerToAttack == 2) {
            firstPlayer = player2;
            secondPlayer = player1;
        }
        System.out.println("First attacker is " + firstPlayer.getCharacter().getName());

        Battle battle = createBattle(firstPlayer, secondPlayer);

        while (!gameService.isAnyPokemonDead(battle)) {
            gameService.attack(firstPlayer, battle.getPokemon1(),
                    secondPlayer, battle.getPokemon2(),
                    isSpecialAttackOn(battle.getPokemon1()),
                    isSpecialAttackOnForCharacter(firstPlayer));
            if (!gameService.isAnyPokemonDead(battle)) {
                gameService.attack(secondPlayer, battle.getPokemon2(),
                        firstPlayer, battle.getPokemon1(),
                        isSpecialAttackOn(battle.getPokemon2()),
                        isSpecialAttackOnForCharacter(secondPlayer));
            }
        }

        if (!gameService.healthCheckPokemon(battle.getPokemon1())) {
            battle.setWinner(battle.getPokemon2());
            battle.getPokemon1().setHealth(battle.getPokemon1().getOriginalHealth());
            secondPlayer.getCharacter().getPokemonList().add(battle.getPokemon1());
            secondPlayer.getCharacter().getPokemonList().add(battle.getPokemon2());
        } else if (!gameService.healthCheckPokemon(battle.getPokemon2())) {
            battle.setWinner(battle.getPokemon1());
            battle.getPokemon2().setHealth(battle.getPokemon2().getOriginalHealth());
            firstPlayer.getCharacter().getPokemonList().add(battle.getPokemon1());
            firstPlayer.getCharacter().getPokemonList().add(battle.getPokemon2());
        }
        System.out.println(battle.getWinner().getName() + " won the battle");
        return battle;
    }

    private boolean isSpecialAttackOnForCharacter(Player player) {
        System.out.println(player.getName() + " will attack." +
                " Do you want to use your Character's special power?" +
                " You can earn " + player.getCharacter().getSpecialPower().getOriginalExtraDamage() + " extra damage!");
        return Helper.yesOrNo();

    }

    private boolean isSpecialAttackOn(Pokemon pokemon) {
        System.out.println("Do you want to use your " + pokemon.getName() + "'s special power?" + " You can earn " +
                pokemon.getSpecialPower().getOriginalExtraDamage() + " extra damage!");
        return Helper.yesOrNo();
    }
}
