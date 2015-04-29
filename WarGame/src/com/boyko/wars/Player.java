package com.boyko.wars;

import java.util.Deque;
import java.util.LinkedList;

public class Player {
    private String name;
    public Deque<Card> playerDeck;

    public Player(String name) {
        this.name = name;
        playerDeck = new LinkedList<Card>();
    }

    public String getName() {
        return name;
    }

    public int deckSize() {
        return playerDeck.size();
    }

    public void getCard(Card card) {
        playerDeck.offerFirst(card);
    }

    public Card showCard() {
        return playerDeck.pollLast();
    }

    public void getAllCards(Deque<Card> warCardDeck, String name) {
        System.out.println("\n========================\n" + name + " win the Battle\n========================\n");
        while (!warCardDeck.isEmpty())
            playerDeck.offerFirst(warCardDeck.poll());
    }

    @Override
    public String toString() {
        return "" + playerDeck.size() + " cards " + playerDeck;
    }
}
