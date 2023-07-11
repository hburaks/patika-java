import model.AwardCategoryEnum;
import model.AwardTypeEnum;
import model.Player;
import model.Team;
import service.PlayerService;
import service.TeamService;
import service.TransferService;

import java.math.BigDecimal;

import static model.CurrencyTypeEnum.EURO;

public class Main {

    //currency dolar,euro, tl

    public static void main(String[] args) {


        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        TransferService transferService = new TransferService();

        Team team = teamService.createTeam("Galatasaray", "GS", "yellow-red",
                "Okan Buruk", "Dursun Özbek", "Nef Arena", new BigDecimal(10000000),
                "Dolar", "Türkiye");

        System.out.println(team.toString());
        teamService.addAwardToTeam(team, "Champions Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.INTERNATIONAL);

        System.out.println(team.toString());

        Team team2 = teamService.createTeam("Fenerbahçe", "FB", "yellow-blue",
                "İsmail Kartal", "Ali Koç", "Kadıköy", new BigDecimal(55000000),
                "Dolar", "Türkiye");


        teamService.addAwardToTeam(team2, "Turkish Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.NATIONAL);

        teamService.addAwardToTeam(team, "League Cup", 2023,
                AwardTypeEnum.CUP, AwardCategoryEnum.NATIONAL);

        System.out.println(team.toString());

        Player player = playerService.createPlayer("Cristiano", "Ronaldo",
                7, 1985, "Forvet", new BigDecimal(35000000), EURO);

        playerService.addTeamToPlayer(player, team);
        System.out.println(player.toString());
        transferService.makeTransfer(player, team2, 2022);
        System.out.println(team);
        System.out.println(team2);
        System.out.println(player);
    }

}