package ru.job4j.serialization.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Athlete {
    private final boolean access;
    private final int number;
    private final String name;
    private final PersonalData sportsman;
    private final Double[] result;

    public Athlete(boolean access, int number, String name, PersonalData sportsman, Double[] result) {
        this.access = access;
        this.number = number;
        this.name = name;
        this.sportsman = sportsman;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Athlete{"
                + "access=" + access
                + ", number=" + number
                + ", name='" + name + '\''
                + ", sportsman=" + sportsman
                + ", result=" + Arrays.toString(result)
                + '}';
    }

    public static void main(String[] args) {
        final Athlete athlete = new Athlete(true, 6578, "Petrov",
                new PersonalData(35, true),
                new Double[] {2.56, 3.48, 2.32});
        final Gson gson = new GsonBuilder().create();
        String athleteToJson = gson.toJson(athlete);
        System.out.println(athleteToJson);
        final Athlete athleteFromJson = gson.fromJson(athleteToJson, Athlete.class);
        System.out.println(athleteFromJson);
    }
}
