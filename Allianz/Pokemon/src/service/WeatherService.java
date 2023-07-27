package service;

import Helper.Helper;
import model.WeatherTypeEnum;

public class WeatherService {

    public WeatherTypeEnum createWeather() {
        WeatherTypeEnum weather = null;
        int weatherTypeIndex = Helper.createRandomNum(1, 4);
        if (weatherTypeIndex == 1) {
            weather = WeatherTypeEnum.RAINY;
        } else if (weatherTypeIndex == 2) {
            weather = WeatherTypeEnum.HOT;
        } else if (weatherTypeIndex == 3) {
            weather = WeatherTypeEnum.CLOUDY;
        } else if (weatherTypeIndex == 4) {
            weather = WeatherTypeEnum.WINDY;
        }
        System.out.println("Weather is " + weather.getStringValue() + ". Bad for " + weather.getCorrespondingPowerType().getStringValue() + " Powers.");
        return weather;
    }


}
