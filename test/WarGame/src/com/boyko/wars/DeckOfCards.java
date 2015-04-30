package com.boyko.wars;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class DeckOfCards implements Iterable<Card> {
    String[] suits = { "♠", "♥", "♦", "♣" };
    String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
    private Stack<Card> cardDeck;

    public DeckOfCards() {
        cardDeck = createDeck();
    }

    private Stack<Card> createDeck() {
        Stack<Card> stack = new Stack<Card>();
        for (int i = 0, suitsCounter = 0, ranksCounter = -1; i < 52; i++) {
            if (ranksCounter == ranks.length - 1) {
                suitsCounter++;
                ranksCounter = -1;
            }
            stack.push(new Card(suits[suitsCounter], ranks[++ranksCounter]));
        }
        Collections.shuffle(stack);
        return stack;
    }

    @Override
    public String toString() {
        return "Playing cards deck ==> " + cardDeck;
    }

    @Override
    public Iterator<Card> iterator() {
        return cardDeck.iterator();
    }
}
