package com.z.aircraft;

import com.z.WeatherTower;

import java.util.HashMap;
import java.util.Map;

import static com.z.Weather.*;

public class JetPlane extends AirCraft implements Flyable{
    private WeatherTower weatherTower;

    final private static Map<String, Coordinates> SHIFTS = new HashMap<>();
    final private static Map<String, String> COMMENTS = new HashMap<>();
    static {
        SHIFTS.put(SUN, new Coordinates(0, 5, 2));
        SHIFTS.put(RAIN, new Coordinates(0, 5, 0));
        SHIFTS.put(FOG, new Coordinates(0, 1, 0));
        SHIFTS.put(SNOW, new Coordinates(0, 0, -7));

        COMMENTS.put(SUN, "Let's enjoy the good weather and take some pics.");
        COMMENTS.put(RAIN, "It's raining. Better watch out for lighting.");
        COMMENTS.put(FOG, "It's fogging. I can't see anything.");
        COMMENTS.put(SNOW, "It's snowing. We're gonna crash." );
    }

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private String getComment() {
        return COMMENTS.get(weatherTower.getWeather(coordinates));
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
        shiftAircraft(SHIFTS.get(weatherTower.getWeather(coordinates)));
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
