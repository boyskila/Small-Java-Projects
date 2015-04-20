package com.boyko.wars;

import java.util.Deque;
import java.util.LinkedList;

public class PlayerCardsDeck {

    private Deque<Card> playingDeck;

    public PlayerCardsDeck() {

        playingDeck = new LinkedList<>();

    }

    public Card showCard() {

        return playingDeck.pollLast();

    }

    public void loadThePlayerCardDeck(Card e) {

        playingDeck.add(e);

    }

    public boolean isEmpty() {

        return playingDeck.isEmpty();
    }

    @Override
    public String toString() {

        return "" + playingDeck;
    }

}
