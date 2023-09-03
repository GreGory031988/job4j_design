package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        List<String> list = logFilter.filter();
                list.forEach(System.out::println);
    }
}
