package com.boyko.wars;

import java.io.IOException;

public class CardVisualization {
    
    private final FileManagerInetrface fileManager = FileManagerFactory.getInstance();
    public CardVisualization(Card card) throws IOException {
        System.out.println(drawCard(card));
    }

    private String drawCard(Card card) throws IOException {
        String pattern = fileManager.readFile();
        for (int i = 0; i < 2; i++) {
            pattern = pattern.contains("V") ? pattern.replaceAll("V", card.getValue())
                    : pattern.contains("S") ? pattern.replace("S", card.getSuit()) : pattern;
        }
        return pattern;
    }
}
