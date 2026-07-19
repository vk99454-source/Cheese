package org.example;

import java.util.ArrayList;

public class CheeseParser {

    public Cheese parseLine(String line) {
        ArrayList<String> values = separateValues(line);

        if (values.size() < 10) {
            return null;
        }

        String moisturePercent = values.get(3);
        String organic = values.get(6);
        String milkType = values.get(8);
        String milkTreatmentType = values.get(9);

        return new Cheese(
                milkTreatmentType,
                organic,
                moisturePercent,
                milkType
        );
    }

    private ArrayList<String> separateValues(String line) {
        ArrayList<String> values = new ArrayList<>();
        String currentValue = "";
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char currentCharacter = line.charAt(i);

            if (currentCharacter == '"') {
                insideQuotes = !insideQuotes;
            } else if (currentCharacter == ',' && !insideQuotes) {
                values.add(currentValue.trim());
                currentValue = "";
            } else {
                currentValue += currentCharacter;
            }
        }

        values.add(currentValue.trim());

        return values;
    }
}