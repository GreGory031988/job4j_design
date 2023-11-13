package ru.job4j.serialization.java;

import java.util.Arrays;

public class Person {
    private boolean sex;
    private int age;
    private Contact contact;
    private String[] statuses;

    public Person() {
    }

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    public boolean getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}