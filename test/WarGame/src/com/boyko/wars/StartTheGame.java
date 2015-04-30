package com.boyko.wars;

import java.io.IOException;

public class StartTheGame {

    public static void main(String[] args) throws IOException {
        new BattleArea(new DeckOfCards(), new Player("Gosho"), new Player("Pesho"));
    }
}
