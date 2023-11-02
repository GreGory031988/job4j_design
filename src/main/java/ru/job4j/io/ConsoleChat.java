package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> chat = new ArrayList<>();
        List<String> phrases = readPhrases();
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Введите слово/фразу: ");
        boolean answer = true;
        String inputData = input.nextLine();
        while (!Objects.equals(inputData, OUT)) {
            chat.add(inputData);
            if (Objects.equals(inputData, STOP)) {
                answer = false;
            } else if (Objects.equals(inputData, CONTINUE)) {
                answer = true;
            }
            if (answer) {
                int index = random.nextInt(phrases.size());
                String reply = phrases.get(index);
                System.out.println(reply);
                chat.add(reply);
            }
            System.out.print("Введите слово/фразу: ");
            inputData = input.nextLine();
        }
        chat.add(inputData);
        saveLog(chat);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/answer.txt"))) {
            br.lines().map(s -> s + System.lineSeparator()).forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("data/record.txt",
                StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/record.txt", "data/answer.txt");
        cc.run();
    }
}
