package model;

import java.time.LocalDate;

abstract class Insurance {
    private String  name;
    private double priceAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    public abstract void calculate();

}
