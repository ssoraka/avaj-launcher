package com.z;

import com.z.aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static String weather[] = new String[]{"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int id = Math.abs(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());
        return weather[id % 4];
    }
}
