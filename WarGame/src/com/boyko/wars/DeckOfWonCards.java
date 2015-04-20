package com.boyko.wars;

import java.util.Deque;
import java.util.LinkedList;

public class DeckOfWonCards {

    private Deque<Card> resultDeck;

    public DeckOfWonCards() {

        resultDeck = new LinkedList<>();
    }

    public int size() {
        return resultDeck.size();
    }

    public void takeCardsAfterWin(Card card1, Card card2) {

        resultDeck.offerFirst(card1);
        resultDeck.offerFirst(card2);

    }

    public void takeCardsAfterWar(Card card) {

        resultDeck.offerFirst(card);

    }

    public Card takeHelpingCard() {

        return resultDeck.pollFirst();

    }

    public void winnerLoop(Deque<Card> warCardDeck, String name) {

        System.out.println("\n========================\n" + name + " win the Battle\n========================\n");

        while (!warCardDeck.isEmpty())

            resultDeck.offerFirst(warCardDeck.poll());

    }

    @Override
    public String toString() {
        return "" + resultDeck.size() + " cards " + resultDeck;
    }
}
