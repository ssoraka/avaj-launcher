package ex;

import ex.aircraft.AircraftFactory;

public class Line {
    private String name;
    private String type;
    private int longitude;
    private int latitude;
    private int height;

    public Line(String line) {
        final String[] arr = line.split("\\s+");
        if (arr.length != 5) {
            throw new ValidationException("Error in line: " + line + ". Wrong count of arguments");
        }

        type = arr[0];
        if (!AircraftFactory.canCreateType(type)) {
            throw new ValidationException("Error in line: " + line + ". Wrong type of aircraft");
        }
        name = arr[1];
        longitude = Integer.parseInt(arr[2]);
        latitude = Integer.parseInt(arr[3]);
        height = Integer.parseInt(arr[4]);
        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new ValidationException("Error in line: " + line + ". Coordinates must be positive numbers");
        }
        if (height >= 100) {
            throw new ValidationException("Error in line: " + line + ". Height must be less than 100");
        }
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
