package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

import static java.lang.System.*;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            for (String s : Arrays.asList("1 * 2 = 2", lineSeparator(), "1 * 3 = 3",
                    lineSeparator(), "1 * 4 = 4", lineSeparator(), "1 * 5 = 5",
                    lineSeparator(), "1 * 6 = 6", lineSeparator(), "1 * 7 = 7",
                    lineSeparator(), "1 * 8 = 8", lineSeparator(), "1 * 9 = 9",
                    lineSeparator())) {
                out.write(s.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
