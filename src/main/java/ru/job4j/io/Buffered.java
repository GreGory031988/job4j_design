package ru.job4j.io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        try (BufferedReader in =
                     new BufferedReader(new FileReader("data/newData.txt"));
             BufferedWriter out =
                     new BufferedWriter(new FileWriter("data/output.txt", true))) {
            String line;
            while ((line = in.readLine()) != null) {
                out.write(line);
                out.write("\n");
            }
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
