package com.z;

public class JetPlane extends AirCraft implements Flyable{
    private WeatherTower weatherTower;


    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates)) {
            case "SUN" :
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.println(name + "(" + id +"): Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN" :
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                System.out.println(name + "(" + id +"): It's raining. Better watch out for lightings.");
                break;
            case "FOG" :
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                System.out.println(name + "(" + id +"): It's fogging. I can't see anything.");
                break;
            case "SNOW" :
                coordinates.setHeight(coordinates.getHeight() - 7);
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
