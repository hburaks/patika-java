package model;

public enum WeatherTypeEnum {
    /*
    *, , , EARTH;
    * FIRE X RAIN
    * WATER X WINDY
    * ELECTRICITY X HOT WEATHER
    *
    *
    * */
    RAINY("Rainy", TypeEnum.FIRE),
    WINDY("Windy",TypeEnum.WATER),
    HOT("Hot", TypeEnum.ELECTRICY),
    CLOUDY("Cloudy",TypeEnum.EARTH);

    private String stringValue;
    private TypeEnum correspondingPowerType;

    WeatherTypeEnum(String stringValue, TypeEnum correspondingPowerType) {
        this.stringValue = stringValue;
        this.correspondingPowerType = correspondingPowerType;
    }

    public String getStringValue() {
        return stringValue;
    }


    public TypeEnum getCorrespondingPowerType() {
        return correspondingPowerType;
    }

}
