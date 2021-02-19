package com.z;

public class Baloon extends AirCraft implements Flyable{
    private WeatherTower weatherTower;


    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates)) {
            case "SUN" :
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() + 4, coordinates.getHeight());
                System.out.println(name + "(" + id +"): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN" :
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() + 5);
                System.out.println(name + "(" + id +"): It's raining. Better watch out for lightings.");
                break;
            case "FOG" :
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() + 3);
                System.out.println(name + "(" + id +"): It's fogging. I can't see anything.");
                break;
            case "SNOW" :
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                System.out.println(name + "(" + id +"): It's snowing. We're gonna crash.");
                break;
        }

        if (coordinates.getHeight() <= 0) {
            System.out.println(name + "(" + id +"): landing.");
            weatherTower.unregister(this);
            System.out.println("Tower says: " + name + "(" + id +") unregistered to weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        if (this.weatherTower != null)
            this.weatherTower.unregister(this);
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        System.out.println("Tower says: " + name + "(" + id +") registered to weather tower.");
    }
}
