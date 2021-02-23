package com.z;

import com.z.aircraft.AircraftFactory;
import com.z.aircraft.Flyable;

import java.util.List;

public class Simulator {
    public static void main(String[] args) {

        if (args.length != 1)
            throw new RuntimeException("Wrong count of argument");

        Scenario scenario = new Scenario(args[0]);

        WeatherTower tower = new WeatherTower();

        List<Line> lines = scenario.getLines();
        for (Line l : lines) {
            Flyable flyable = AircraftFactory.newAircraft(
                    l.getType(),
                    l.getName(),
                    l.getLongitude(),
                    l.getLatitude(),
                    l.getHeight()
            );
            flyable.registerTower(tower);
        }


//        WeatherTower tower = new WeatherTower();
//
//        AircraftFactory.newAircraft("Baloon", "dsa", 1, 1, 1).registerTower(tower);
//        AircraftFactory.newAircraft("Baloon", "dsa2", 3, 3, 3).registerTower(tower);
//
        for (int i = 0; i < scenario.getCount(); i++) {
            tower.changeWeather();
        }

    }
}
