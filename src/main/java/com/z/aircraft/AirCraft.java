package com.z.aircraft;

public abstract class AirCraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long idCounter;

    protected AirCraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    private long nextId() {
        return idCounter++;
    }

    protected void shiftAircraft(Coordinates shift) {
        coordinates = new Coordinates(
                coordinates.getLongitude() + shift.getLongitude(),
                coordinates.getLatitude() + shift.getLatitude(),
                coordinates.getHeight() + shift.getHeight()
        );
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }
}
