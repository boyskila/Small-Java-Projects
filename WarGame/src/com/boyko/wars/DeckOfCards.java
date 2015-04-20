package com.boyko.wars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {

    String[] suits = { "♠", "♥", "♦", "♣" };
    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

    private List<Card> cardDeck;

    public DeckOfCards() {
        cardDeck = new ArrayList<>();
        for (int i = 0, suitsCounter = 0, ranksCounter = -1; i < 52; i++) {

            if (ranksCounter == ranks.length - 1) {
                suitsCounter++;
                ranksCounter = -1;
            }
            cardDeck.add(new Card(suits[suitsCounter], ranks[++ranksCounter]));
        }
        Collections.shuffle(cardDeck);
    }

    public Card getCard(int i) {
        return cardDeck.get(i);

    }

    public int size() {

        return cardDeck.size();
    }

    @Override
    public String toString() {
        return "Playing cards deck ==> " + cardDeck;
    }
}
