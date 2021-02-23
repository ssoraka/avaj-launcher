package com.z;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private int count;
    private List<Line> lines;

    public Scenario(String path) {
        count = -1;
        lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.length() != 0) {
                    if (count != -1)
                        lines.add(new Line(line));
                    else if (line.matches("\\d+"))
                        count = Integer.parseInt(line);
                    else throw new ValidationException("Wrong first line");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (count == -1)
            throw new ValidationException("Incorrect parameters");
    }

    public int getCount() {
        return count;
    }

    public List<Line> getLines() {
        return lines;
    }
}
