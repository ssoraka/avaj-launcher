package ex.aircraft;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AircraftFactory {

    private static Map<String, BiFunction<String, Integer, BiFunction<Integer, Integer, Flyable>>> CONSTRUCTORS;
    static {
        CONSTRUCTORS = new HashMap<>();
        CONSTRUCTORS.put("Baloon", (n, lng) -> (ltd, h) ->  new Baloon(n, new Coordinates(lng, ltd, h)));
        CONSTRUCTORS.put("JetPlane", (n, lng) -> (ltd, h) ->  new JetPlane(n, new Coordinates(lng, ltd, h)));
        CONSTRUCTORS.put("Helicopter", (n, lng) -> (ltd, h) ->  new Helicopter(n, new Coordinates(lng, ltd, h)));
    }

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (CONSTRUCTORS.containsKey(type))
            return CONSTRUCTORS.get(type).apply(name, longitude).apply(latitude, height);
        throw new RuntimeException("no such class");
    }

    public static boolean canCreateType(String type) {
        return CONSTRUCTORS.containsKey(type);
    }
}
