package com.boyko.wars;

import java.io.IOException;

public class CardVisualization {

    public static String drawCard(Card card, String pattern) throws IOException {
        return pattern.replace("V", card.getValue()).replace("S", card.getSuit());
    }
}
