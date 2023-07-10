package service;

import model.Award;
import model.AwardCategoryEnum;
import model.AwardTypeEnum;
import model.Team;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TeamService {

    public Team createTeam(String teamName, String nickName, String colors, String coach, String president,
                           String stadiumName, BigDecimal budget, String currency, String country) {

        Team team = new Team();
        team.setName(teamName);
        team.setNickName(nickName);
        team.setColors(colors);
        team.setCoach(coach);
        team.setPresident(president);
        team.setStadiumName(stadiumName);
        team.setBudget(budget);
        team.setCurrency(currency);
        team.setCountry(country);
        return team;
    }

    /*

        private String name;
    private int year;
    private AwardTypeEnum awardType;
    private AwardCategoryEnum awardCategory;


     */

    public void addAwardToTeam(Team team, String name, int year,
                               AwardTypeEnum awardTypeEnum, AwardCategoryEnum awardCategoryEnum) {

        Award award = new Award();
        award.setName(name);
        award.setYear(year);
        award.setAwardCategory(awardCategoryEnum);
        award.setAwardType(awardTypeEnum);

        if(team.getAwards()!=null){
            team.getAwards().add(award);
        }
        else {
            List<Award> awardList = new ArrayList<>();
            awardList.add(award);
            team.setAwards(awardList);
        }
    }


}
