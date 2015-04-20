package com.boyko.wars;

public class StartTheGame {

    public static void main(String[] args) {

        Player p1 = new Player("Gosho");
        Player p2 = new Player("Pesho");

        DeckOfCards deckOfCards = new DeckOfCards();

        for (int i = 1; i < deckOfCards.size(); i += 2) {

            p1.playerDeck.loadThePlayerCardDeck(deckOfCards.getCard(i - 1));
            p2.playerDeck.loadThePlayerCardDeck(deckOfCards.getCard(i));
        }

        System.out.println(deckOfCards.toString() + "\n");

        new BattleArea(p1, p2);

    }
}
