package com.example.AppointmentBackend.Utils;

import java.util.Random;
import java.util.stream.Collectors;

public class GenerateOtp {
    private static final String CHARACTERS = "abcdefghijklmnpqrstuvwxyz123456789";
    private static final Random RANDOM = new Random();
    private static final int DEFAULT_LENGTH = 8;

    public static String generate(int length) {
        return RANDOM.ints(length, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public static String generate() {
        return generate(DEFAULT_LENGTH);
    }
}
