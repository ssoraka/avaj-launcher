package com.z;

import com.z.aircraft.AircraftFactory;

public class Simulator {
    public static void main(String[] args) {

        //читаем и создаем летающие средства и регистрируем в башне

        final WeatherTower tower = new WeatherTower();


        AircraftFactory.newAircraft("Baloon", "dsa", 1, 1, 1).registerTower(tower);
        AircraftFactory.newAircraft("Baloon", "dsa2", 3, 3, 3).registerTower(tower);


        for (int i = 0; i < 3; i++) {
            tower.changeWeather();
        }

    }
}
