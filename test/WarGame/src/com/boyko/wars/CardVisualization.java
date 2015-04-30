package com.boyko.wars;

import java.io.IOException;

public class CardVisualization {

    public static String drawCard(Card card, String pattern) throws IOException {
        return pattern = pattern.contains("V") ? pattern.replaceAll("V", card.getValue())
                : pattern.contains("S") ? pattern.replaceAll("S", card.getSuit()) : pattern;
    }
}
