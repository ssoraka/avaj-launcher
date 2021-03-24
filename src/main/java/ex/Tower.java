package ex;

import ex.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
        System.out.println("Tower says: " + flyable.toString() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
        System.out.println("Tower says: " + flyable.toString() + " unregistered to weather tower.");
    }

    void conditionsChanged() {
        List<Flyable> list = new ArrayList<>(observers);
        for (Flyable f : list) {
            f.updateConditions();
        }
    }
}
