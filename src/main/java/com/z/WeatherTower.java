package com.z;

import com.z.aircraft.Coordinates;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        conditionsChanged();
    }
}
