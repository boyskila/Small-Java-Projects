package com.boyko.wars;

public class StartTheGame {

    public static void main(String[] args) {
        new BattleArea(new DeckOfCards(), new Player("Gosho"), new Player("Pesho"));
    }
}
