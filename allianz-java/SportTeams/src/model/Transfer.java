package model;

import java.math.BigDecimal;

public class Transfer {
    private Team fromTeam;
    private Team toTeam;
    private int year;
    private BigDecimal price;
    private CurrencyTypeEnum currency;

    public Transfer(Team fromTeam, Team toTeam, int year, BigDecimal price, CurrencyTypeEnum currency) {
        this.fromTeam = fromTeam;
        this.toTeam = toTeam;
        this.year = year;
        this.price = price;
        this.currency = currency;
    }
    public Team getFromTeam() {
        return fromTeam;
    }


    public void setFromTeam(Team fromTeam) {
        this.fromTeam = fromTeam;
    }

    public Team getToTeam() {
        return toTeam;
    }

    public void setToTeam(Team toTeam) {
        this.toTeam = toTeam;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CurrencyTypeEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyTypeEnum currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "fromTeam=" + fromTeam.getName() +
                ", toTeam=" + toTeam.getName() +
                ", year=" + year +
                ", price=" + price +
                ", currency=" + currency +
                '}';
    }
}
