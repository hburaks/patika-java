package service;

import model.CurrencyTypeEnum;
import model.Player;
import model.Team;
import model.Transfer;

import java.math.BigDecimal;
public class TransferService {

    /*
    public Transfer(Team fromTeam, Team toTeam, int year, BigDecimal price, String currency) {
        this.fromTeam = fromTeam;
        this.toTeam = toTeam;
        this.year = year;
        this.price = price;
        this.currency = currency;
    } */

    public void makeTransfer(Player player, Team toTeam, int year){
        BigDecimal playerValue = player.getValue();
        CurrencyTypeEnum playerValueCurrency = player.getCurrency();
        playerValue =  CurrencyService.convertCurrencyToUSD(playerValue, playerValueCurrency);

        if(toTeam.getBudget().compareTo(playerValue)>=0){
            System.out.println("transfer can be done");
            toTeam.setBudget(toTeam.getBudget().subtract(playerValue));
            Team fromTeam = player.getTeamList().get(player.getTeamList().size()-1);
            fromTeam.setBudget(fromTeam.getBudget().add(playerValue));
            player.getTeamList().add(toTeam);
            Transfer transfer = createTransfer(fromTeam, toTeam, year, player.getValue(), playerValueCurrency);
            player.getTransferHistory().add(transfer);
        }
        else{
            System.err.println("transfer can not be done because of not enough budget");
        }
    }
    public Transfer createTransfer(Team fromTeam, Team toTeam, int year, BigDecimal price, CurrencyTypeEnum currency){
        Transfer transfer = new Transfer(fromTeam, toTeam, year, price, currency);
        return  transfer;
    }

}
