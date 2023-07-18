package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Policy {
    private InsuranceCompany insuranceCompany;
    private Vehicle vehicle;
    private BigDecimal price;
    private LocalDate startDate;
    private LocalDate endDate;

    public Policy() {
    }

    public Policy(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal price, LocalDate startDate, LocalDate endDate) {
        this.insuranceCompany = insuranceCompany;
        this.vehicle = vehicle;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "insuranceCompany=" + insuranceCompany +
                ", vehicle=" + vehicle +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}' + "\n";
    }
}
