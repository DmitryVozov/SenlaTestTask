package ru.vozov.gallows.game;

import ru.vozov.gallows.helper.ConsoleHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GallowsGame {
    private final List<String> words = new ArrayList<>();
    private final String word;
    private final char[] guessedWord;
    private int livesCount = 6;

    public GallowsGame() {
        words.add("программирование");
        words.add("инвестиция");
        words.add("тренировка");
        words.add("книга");
        words.add("здоровье");
        words.add("семья");

        word = getRandomWord();
        guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '*');
    }

    private String getRandomWord() {
        return words.get(
                (int) (Math.random() * words.size())
        );
    }

    public boolean isEnd() {
        return livesCount == 0 || !String.valueOf(guessedWord).contains("*");
    }

    public boolean isLose() {
        return livesCount == 0;
    }

    public void findChar(char ch) {
        boolean isFind = false;
        ch = Character.toLowerCase(ch);

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch && guessedWord[i] == '*') {
                guessedWord[i] = ch;

                if (!isFind) {
                    isFind = true;
                }
            }
        }

        if (!isFind) {
            livesCount--;
        }
    }

    public void showGuessedWord() {
        ConsoleHelper.writeMessage(
                String.format(
                    "Загадываемое слово: %s", String.valueOf(guessedWord)
                )
        );
    }

    public void showLivesCount() {
        ConsoleHelper.writeMessage(
                String.format(
                        "Осталось жизней: %d", livesCount
                )
        );
    }
}
