package ex.aircraft;

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
        return ++idCounter;
    }

    protected void shiftAircraft(Coordinates shift) {
        coordinates = new Coordinates(
                coordinates.getLongitude() + shift.getLongitude(),
                coordinates.getLatitude() + shift.getLatitude(),
                Math.min(coordinates.getHeight() + shift.getHeight(), 100)
        );
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "#" + name + "(" + id + ")";
    }
}
