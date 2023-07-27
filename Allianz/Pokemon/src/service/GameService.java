package service;

import model.Battle;
import model.Player;
import model.Pokemon;

public class GameService {

    public void attack(Player attacker, Pokemon attackingPokemon, Player defender,Pokemon defendingPokemon, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {

        boolean specialAttack = false;
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainingRights();

        int damage = 0;
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);

            } else if (isPokeSpecialAttack) {
                damage += attackingPokemon.specialAttack();
            } else {
                damage += attackingPokemon.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
            }
        } else {
            if (isPokeSpecialAttack || isCharSpecialAttack) {
                System.out.println("Oops! Attack missed. No special power left!");
                damage = 0;
            } else {
                damage += attackingPokemon.getDamage();
            }
        }
        if(defendingPokemon.getHealth() - damage < 0){
            defendingPokemon.setHealth(0);
        } else {
            defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
        }
        System.out.println(attackingPokemon.getName() + " attacked with " + damage);
        System.out.println(defendingPokemon.getName() + " has " + defendingPokemon.getHealth() + " health");
    }

    public boolean healthCheck(Player player){
        if(player.getCharacter().getPokemonList().get(0).getHealth() > 0){
            System.out.println(player.toString());
            System.out.println("Oyun devam ediyor.");
            return true;

        } else {
            System.out.println(player.toString());
            System.out.println(player.getName() + " oyunu kaybetti");
            return false;
        }
    }
    public boolean healthCheckPokemon(Pokemon pokemon){
        if(pokemon.getHealth() > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnyPokemonDead(Battle battle){
        GameService gameService = new GameService();
       return !(gameService.healthCheckPokemon(battle.getPokemon1()) && gameService.healthCheckPokemon(battle.getPokemon2()));
    }
}
