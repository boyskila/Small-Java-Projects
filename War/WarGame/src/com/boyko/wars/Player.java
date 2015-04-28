package com.boyko.wars;

import java.util.Deque;
import java.util.LinkedList;

public class Player {

    private String name;
    Deque<Card> playerDeck;

    public Player(String name) {

        this.name = name;
        playerDeck = new LinkedList<Card>();

    }

    public String getName() {
        return name;
    }
    public int size() {

        return playerDeck.size();

    }

  public boolean isEmpty() {

      return playerDeck.isEmpty();
  }

    public void takeCardsAfterWin(Card card1, Card card2) {

        playerDeck.offerFirst(card1);
        playerDeck.offerFirst(card2);

    }

    public void takeCardsAfterWar(Card card) {

        playerDeck.offerFirst(card);

    }

    public Card takeHelpingCard() {

        return playerDeck.pollFirst();

    }
    public void loadThePlayerCardDeck(Card e) {

        playerDeck.add(e);

    }

    public Card showCard() {

        return playerDeck.pollLast();

    }

    public void winnerLoop(Deque<Card> warCardDeck, String name) {

        System.out.println("\n========================\n" + name + " win the Battle\n========================\n");

        while (!warCardDeck.isEmpty())

            playerDeck.offerFirst(warCardDeck.poll());

    }

    @Override
    public String toString() {

        return "" + playerDeck.size() + " cards " + playerDeck;

    }
}
