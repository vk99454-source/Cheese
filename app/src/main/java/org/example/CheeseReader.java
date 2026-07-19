package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheeseReader {
    private CheeseParser parser;

    public CheeseReader() {
        parser = new CheeseParser();
    }

    public ArrayList<Cheese> readCheeses(String fileName) {
        ArrayList<Cheese> cheeses = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(new File(fileName));

            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Cheese cheese = parser.parseLine(line);

                if (cheese != null) {
                    cheeses.add(cheese);
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }

        return cheeses;
    }
}