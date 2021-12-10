package com.epam.shape.util;

public class IdGenerator {
    private static Integer counter = 1;

    private IdGenerator() {

    }

    public static Integer generateId() {
        return counter++;
    }
}
