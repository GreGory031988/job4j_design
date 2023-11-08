package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Gregorii Kashin";
        int age = 0B100011;
        byte birthday = 3;
        char gender = 'M';
        float height = 1.86F;
        double weight = 74.8;
        short number = 6154;
        boolean result = true;
        long distance = 12345678999L;

        LOG.info("""
                        User info name : {}, age : {}, birthday : {},
                        gender : {}, height : {}, weight : {},
                        number : {}, result : {}, distanse : {}.""",
                name, age, birthday, gender, height, weight, number, result, distance);
    }
}
