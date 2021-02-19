package com.z;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
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
