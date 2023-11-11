package ru.job4j.serialization.java;

public class PersonalData {
    private final int age;
    private final boolean masterOfSport;

    public PersonalData(int age, boolean masterOfSport) {
        this.age = age;
        this.masterOfSport = masterOfSport;
    }

    @Override
    public String toString() {
        return "PersonalData{"
                + "age=" + age
                + ", masterOfSport=" + masterOfSport
                + '}';
    }
}
