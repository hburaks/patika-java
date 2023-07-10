package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private String surname;

    private int kitNumber;

    private int birthYear;

    private String position;

    private List<Transfer> transferHistory = new ArrayList<>();

    private List<Team> teamList;

    private BigDecimal value;

    private CurrencyTypeEnum currency;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(int kitNumber) {
        this.kitNumber = kitNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Transfer> getTransferHistory() {
        return transferHistory;
    }

    public void setTransferHistory(List<Transfer> transferHistory) {
        this.transferHistory = transferHistory;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public CurrencyTypeEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyTypeEnum currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", kitNumber=" + kitNumber +
                ", birthYear=" + birthYear +
                ", position='" + position + '\'' +
                ", transferHistory=" + transferHistory.toString() +
                ", teamList=" + teamList +
                ", value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
