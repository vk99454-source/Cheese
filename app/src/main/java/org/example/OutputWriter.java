package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutputWriter {

    public void writeOutput(String fileName, String output) {
        try {
            PrintWriter writer = new PrintWriter(fileName);

            writer.print(output);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not create file: " + fileName);
        }
    }
}