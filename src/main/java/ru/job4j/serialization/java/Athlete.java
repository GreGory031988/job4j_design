package ru.job4j.serialization.java;

import org.json.JSONObject;
import java.util.Arrays;

public class Athlete {
    private final boolean access;
    private final int number;
    private final String name;
    private final PersonalData sportsman;
    private final Double[] result;

    public Athlete(boolean access, int number, String name, PersonalData sportsman, Double... result) {
        this.access = access;
        this.number = number;
        this.name = name;
        this.sportsman = sportsman;
        this.result = result;
    }

    public boolean getAccess() {
        return access;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public PersonalData getSportsman() {
        return sportsman;
    }

    public Double[] getResult() {
        return result;
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

    public static void main(String[] args) throws Exception {
        final Athlete athlete = new Athlete(true, 456, "Ivanov",
                new PersonalData(24, false),
                3.56, 4.15, 4.03);
        JSONObject jsonPersonalData = new JSONObject();
        jsonPersonalData.put("age", athlete.getSportsman().getAge());
        jsonPersonalData.put("masterOfSport", athlete.getSportsman().getMasterOfSport());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("access", athlete.getAccess());
        jsonObject.put("number", athlete.getNumber());
        jsonObject.put("name", athlete.getName());
        jsonObject.put("sportsman", jsonPersonalData);
        jsonObject.put("result", athlete.getResult());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(athlete).toString());
    }
}
