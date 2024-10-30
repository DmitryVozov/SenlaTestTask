package ru.vozov.gallows;

import ru.vozov.gallows.service.GallowsService;

public class Gallows {
    private static final GallowsService gallowsService = new GallowsService();

    public static void main(String[] args) {
        gallowsService.startGame();
    }
}
