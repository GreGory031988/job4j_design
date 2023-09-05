package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           while (in.read() != -1) {
               String[] lines = (in.readLine()).split(" ");
               if ("404".equals(lines[lines.length - 2])) {
                   list.add(String.join(" ", lines));
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter outTxt = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)
        ))) {
            for (String line : data) {
                outTxt.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LogFilter("data/log.txt").saveTo("data/404.txt");
    }
}
