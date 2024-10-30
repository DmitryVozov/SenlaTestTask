package ru.vozov.gallows.service;

import ru.vozov.gallows.game.GallowsGame;
import ru.vozov.gallows.helper.ConsoleHelper;

import java.io.IOException;

public class GallowsService {
    private final GallowsGame gallowsGame = new GallowsGame();

    public void startGame() {
        while(!gallowsGame.isEnd()) {
            ConsoleHelper.writeMessage("Введите букву для загаданного слова: ");
            String str;

            try {
                str = ConsoleHelper.readString();
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при вводе буквы.");
                continue;
            }

            if (str.length() != 1) {
                ConsoleHelper.writeMessage("Вводите только одну букву.");
                continue;
            }

            if (!Character.isLetter(str.charAt(0))) {
                ConsoleHelper.writeMessage("Вводите только буквы.");
                continue;
            }

            gallowsGame.findChar(str.charAt(0));
            gallowsGame.showGuessedWord();
            gallowsGame.showLivesCount();
        }

        if (gallowsGame.isLose()) {
            ConsoleHelper.writeMessage("Вы проиграли!");
        }
        else {
            ConsoleHelper.writeMessage("Вы выиграли!");
        }
    }

}
