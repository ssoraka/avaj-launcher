package com.z;

import com.z.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        System.out.print("Tower says: ");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        System.out.print("Tower says: ");
        if (observers.contains(flyable)) {
            observers.remove(flyable);
        }
    }

    void conditionsChanged() {
        List<Flyable> list = new ArrayList<>(observers);
        for (Flyable f : list) {
            f.updateConditions();
        }
    }
}
