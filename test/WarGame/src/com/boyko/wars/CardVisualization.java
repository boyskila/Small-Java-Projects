package com.boyko.wars;

import java.io.IOException;

public class CardVisualization {
    public CardVisualization(Card card) throws IOException {
        System.out.println(drawCard(card));
    }

    private String drawCard(Card card) throws IOException {
        String pattern = FileManager.readFile();
        for (int i = 0; i < 2; i++) {
            pattern = pattern.contains("1") ? pattern.replaceAll("1", card.getValue())
                    : pattern.contains("2") ? pattern.replace("2", card.getSuit()) : pattern;
        }
        return pattern;
    }
}
