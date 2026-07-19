package org.example;

import java.util.ArrayList;

public class CheeseCalculator {
    private ArrayList<Cheese> cheeses;

    public CheeseCalculator(ArrayList<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

    public int countPasteurizedCheeses() {
        int count = 0;

        for (Cheese cheese : cheeses) {
            if (cheese.getMilkTreatmentType().equalsIgnoreCase("Pasteurized")) {
                count++;
            }
        }

        return count;
    }

    public int countRawMilkCheeses() {
        int count = 0;

        for (Cheese cheese : cheeses) {
            if (cheese.getMilkTreatmentType().equalsIgnoreCase("Raw Milk")) {
                count++;
            }
        }

        return count;
    }

    public int countOrganicCheesesOver41Moisture() {
        int count = 0;

        for (Cheese cheese : cheeses) {
            String organic = cheese.getOrganic();
            String moisture = cheese.getMoisturePercent();

            if (!organic.isEmpty() && !moisture.isEmpty()) {
                double moisturePercent = Double.parseDouble(moisture);

                if (organic.equals("1") && moisturePercent > 41.0) {
                    count++;
                }
            }
        }

        return count;
    }

    public String findMostCommonMilkType() {
        int cowCount = 0;
        int goatCount = 0;
        int eweCount = 0;
        int buffaloCount = 0;

        for (Cheese cheese : cheeses) {
            String milkType = cheese.getMilkType().toLowerCase();

            if (milkType.contains("buffalo")) {
                buffaloCount++;
            } else {
                if (milkType.contains("cow")) {
                    cowCount++;
                }

                if (milkType.contains("goat")) {
                    goatCount++;
                }

                if (milkType.contains("ewe")) {
                    eweCount++;
                }
            }
        }

        String mostCommon = "Cow";
        int highestCount = cowCount;

        if (goatCount > highestCount) {
            mostCommon = "Goat";
            highestCount = goatCount;
        }

        if (eweCount > highestCount) {
            mostCommon = "Ewe";
            highestCount = eweCount;
        }

        if (buffaloCount > highestCount) {
            mostCommon = "Buffalo";
        }

        return mostCommon;
    }
}