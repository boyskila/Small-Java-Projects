package com.boyko.wars;

public class Player {

    private String name;
    DeckOfWonCards wonCardsDeck;
    PlayerCardsDeck playerDeck;

    public Player(String name) {

        this.name = name;
        wonCardsDeck = new DeckOfWonCards();
        playerDeck = new PlayerCardsDeck();
    }

    public String getName() {
        return name;
    }

}
