package com.z.aircraft;

import com.z.WeatherTower;

import java.util.HashMap;
import java.util.Map;

public class JetPlane extends AirCraft implements Flyable{
    private WeatherTower weatherTower;

    private static Map<String, Coordinates> map = new HashMap<>();
    private static Map<String, String> comments = new HashMap<>();
    static {
        map.put("SUN", new Coordinates(0, 5, 2));
        map.put("RAIN", new Coordinates(0, 5, 0));
        map.put("FOG", new Coordinates(0, 1, 0));
        map.put("SNOW", new Coordinates(0, 0, -7));

        comments.put("SUN", "Let's enjoy the good weather and take some pics.");
        comments.put("RAIN", "It's raining. Better watch out for lightings.");
        comments.put("FOG", "It's fogging. I can't see anything.");
        comments.put("SNOW", "It's snowing. We're gonna crash." );
    }

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private String getComment() {
        return comments.get(weatherTower.getWeather(coordinates));
    }

    private void printMessage() {
        System.out.println(toString() + ": " + getComment());
    }

    private void tryLandingAndUnregister() {
        if (coordinates.getHeight() <= 0) {
            System.out.println(toString() + ": landing.");
            weatherTower.unregister(this);
            System.out.println("Tower says: " + toString() + " unregistered to weather tower.");
        }
    }

    @Override
    public void updateConditions() {
        shiftAircraft(map.get(weatherTower.getWeather(coordinates)));
        printMessage();
        tryLandingAndUnregister();
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: " + toString() + " registered to weather tower.");
    }
}
