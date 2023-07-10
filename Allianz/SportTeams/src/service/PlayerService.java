package service;


import model.CurrencyTypeEnum;
import model.Player;
import model.Team;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerService {


    //yeni bir oyuncu ekliyoruz
    //başlangıcta en az bir takımı olsun


    public Player createPlayer(String name, String surname, int kitNumber, int birthYear,
                               String position, BigDecimal value, CurrencyTypeEnum currency) {

        Player player = new Player();
        player.setName(name);
        player.setSurname(surname);
        player.setKitNumber(kitNumber);
        player.setBirthYear(birthYear);
        player.setPosition(position);
        player.setValue(value);
        player.setCurrency(currency);

        return player;
    }


    public void addTeamToPlayer(Player player, Team team) {

        if (Objects.nonNull(player.getTeamList())) {
            player.getTeamList().add(team);
        } else {
            List<Team> teamList = new ArrayList<>();
            teamList.add(team);
            player.setTeamList(teamList);
        }
    }


    //transfer ettikçe de takım bilgisi güncellenecek

}
