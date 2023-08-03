package model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private Brand brand;
    private BigDecimal unitPrice;
    private BigDecimal discountRatio;
    private int stockAmount;
    private Category category;
    private Double batteryPower;
    private ColorTypeEnum color;


    private Double ram;
    private Double memory;
    private Double screenSize;

    public Double getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Double batteryPower) {
        this.batteryPower = batteryPower;
    }

    public ColorTypeEnum getColor() {
        return color;
    }

    public void setColor(ColorTypeEnum color) {
        this.color = color;
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        this.ram = ram;
    }

    public Double getMemory() {
        return memory;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(BigDecimal discountRatio) {
        this.discountRatio = discountRatio;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
