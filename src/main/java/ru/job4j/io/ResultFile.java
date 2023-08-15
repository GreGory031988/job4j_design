package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("data/dataresult.txt")) {
            out.write("2".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("3".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("4".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("5".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("6".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("7".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("8".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("9".getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
