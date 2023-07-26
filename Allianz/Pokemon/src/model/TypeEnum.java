package model;

public enum TypeEnum {
    FIRE("Fire"), WATER("Water"), ELECTRICY("Electricity"), EARTH("Earth");

    private String stringValue;

    TypeEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

}
