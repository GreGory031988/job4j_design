package ru.job4j.serialization.java;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private final String phone;

    public Contact(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + ", phone='" + phone + '\''
                + '}';
    }
}
