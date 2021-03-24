package ex;

import ex.aircraft.AircraftFactory;
import ex.aircraft.Flyable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Simulator {
    public static void main(String[] args) {

        if (args.length != 1)
            throw new RuntimeException("Wrong count of argument");

        Scenario scenario = new Scenario(args[0]);
        WeatherTower tower = new WeatherTower();

        PrintStream origin = System.out;
        try (PrintStream out = new PrintStream(new FileOutputStream("simulation.txt"))) {
            System.setOut(out);

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

            for (int i = 0; i < scenario.getCount(); i++) {
                tower.changeWeather();
            }

            System.setOut(origin);
        } catch (FileNotFoundException e) {
            System.setOut(origin);
            e.printStackTrace();
        }
    }
}
