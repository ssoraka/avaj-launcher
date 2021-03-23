package ex;

public class Line {
    private String name;
    private String type;
    private int longitude;
    private int latitude;
    private int height;

    public Line(String line) {
        final String[] arr = line.split("\\s+");
        if (arr.length != 5)
            throw new ValidationException("Wrong count of arguments");

        type = arr[0];
        if (!type.equals("Baloon") && !type.equals("JetPlane") && !type.equals("Helicopter"))
            throw new ValidationException("Wrong type of aircraft");
        name = arr[1];
        longitude = Integer.parseInt(arr[2]);
        latitude = Integer.parseInt(arr[3]);
        height = Integer.parseInt(arr[4]);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
