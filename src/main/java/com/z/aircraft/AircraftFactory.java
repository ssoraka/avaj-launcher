package com.z.aircraft;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AircraftFactory {

    private static Map<String, BiFunction<String, Integer, BiFunction<Integer, Integer, Flyable>>> map;
    static {
        map = new HashMap<>();
        map.put("Baloon", (n, lng) -> (ltd, h) ->  new Baloon(n, new Coordinates(lng, ltd, h)));
        map.put("JetPlane", (n, lng) -> (ltd, h) ->  new JetPlane(n, new Coordinates(lng, ltd, h)));
        map.put("Helicopter", (n, lng) -> (ltd, h) ->  new Helicopter(n, new Coordinates(lng, ltd, h)));
    }



    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
//        вариант с 2 аргументами
//        BiFunction<String, Integer, BiFunction<Integer, Integer, Flyable>> f1 = (n, lng) -> (ltd, h) ->  new Baloon(n, new Coordinates(lng, ltd, h));

//        вариант с 1 аргументом
//        Function <String, Function <Integer, Function <Integer, Function<Integer, Flyable>>>> f = n -> lng -> ltd -> h -> new Baloon(n, new Coordinates(lng, ltd, h));
//        применение функции
//        f.apply(name).apply(longitude).apply(latitude).apply(height);

        if (map.containsKey(type))
            return map.get(type).apply(name, longitude).apply(latitude, height);
        throw new RuntimeException("no such class");
    }
}
