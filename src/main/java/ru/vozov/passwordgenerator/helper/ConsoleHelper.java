package ru.vozov.passwordgenerator.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static int readInt() throws IOException, NumberFormatException {
        return Integer.parseInt(in.readLine());
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }
}
