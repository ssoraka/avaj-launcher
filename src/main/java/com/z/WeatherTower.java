package com.z;

public class WeatherTower extends Tower{
    String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        conditionsChanged();
    }
}
