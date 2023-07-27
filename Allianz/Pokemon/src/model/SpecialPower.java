package model;

public class SpecialPower {
    private String name;
    private int extraDamage;
    private int originalExtraDamage;
    private int remainingRights;

    public SpecialPower(String name,int extraDamage, int remainingRights) {
        this.name = name;
        this.remainingRights = remainingRights;
        this.extraDamage = extraDamage;
        this.originalExtraDamage = extraDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(int extraDamage) {
        this.extraDamage = extraDamage;
    }

    public int getRemainingRights() {
        return remainingRights;
    }

    public void setRemainingRights(int remainingRights) {
        this.remainingRights = remainingRights;
    }

    public int getOriginalExtraDamage() {
        return originalExtraDamage;
    }

    @Override
    public String toString() {
        return "SpecialPower{" +
                "name='" + name + '\'' +
                ", extraDamage=" + extraDamage +
                ", remainingRights=" + remainingRights +
                '}';
    }
}
