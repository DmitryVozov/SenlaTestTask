package ru.vozov.passwordgenerator.service;

import ru.vozov.passwordgenerator.helper.ConsoleHelper;

import java.io.IOException;
import java.security.SecureRandom;

public class PasswordGeneratorService {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public int getPasswordLength() {
        while (true) {
            ConsoleHelper.writeMessage("Введите длину пароля от 8 до 12:");
            int length;

            try {
                length = ConsoleHelper.readInt();

                if (length < 8 || length > 12) {
                    ConsoleHelper.writeMessage("Пароль должен содержать от 8 до 12 символов.");
                    continue;
                }

                return length;
            }
            catch (IOException | NumberFormatException e) {
                ConsoleHelper.writeMessage("Ошибка при вводе длины пароля, вводите только числа от 8 до 12.");
            }
        }
    }

    public void generatePassword(int length) {
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder(length);

        password.append(getRandomCharacter(LOWERCASE, random));
        password.append(getRandomCharacter(UPPERCASE, random));
        password.append(getRandomCharacter(DIGITS, random));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS, random));

        String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(allCharacters, random));
        }

        ConsoleHelper.writeMessage(
                String.format(
                        "Ваш сгенерированный пароль: %s",
                        shuffleString(password.toString(), random)
                )
        );
    }

    private char getRandomCharacter(String characters, SecureRandom random) {
        return characters.charAt(random.nextInt(characters.length()));
    }

    private String shuffleString(String input, SecureRandom random) {
        char[] characters = input.toCharArray();

        for (int i = characters.length; i > 1; i--) {
            swap(characters, i - 1, random.nextInt(i));
        }

        return new String(characters);
    }

    private void swap(char[] characters, int i, int j) {
        char temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;
    }
}
