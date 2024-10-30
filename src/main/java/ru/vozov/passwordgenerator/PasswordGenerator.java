package ru.vozov.passwordgenerator;

import ru.vozov.passwordgenerator.service.PasswordGeneratorService;


public class PasswordGenerator {
    private static final PasswordGeneratorService passwordGeneratorService = new PasswordGeneratorService();

    public static void main(String[] args) {
        int length = passwordGeneratorService.getPasswordLength();
        passwordGeneratorService.generatePassword(length);
    }
}
