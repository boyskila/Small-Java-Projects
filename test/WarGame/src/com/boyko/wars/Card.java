package com.boyko.wars;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private String suit;
    private String value;
    private int strenght;
    @SuppressWarnings("serial")
    private Map<String, Integer> cardStrenght = new HashMap<String, Integer>() {
        {
            put("A", 14);
            put("K", 13);
            put("Q", 12);
            put("J", 11);
            put("10", 10);
            put("9", 9);
            put("8", 8);
            put("7", 7);
            put("6", 6);
            put("5", 5);
            put("4", 4);
            put("3", 3);
            put("2", 2);
        }
    };

    public Card() {

    }

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.strenght = cardStrenght.get(value);
    }

    public int getStrenght() {
        return strenght;
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {

        return value + suit;
    }
}
