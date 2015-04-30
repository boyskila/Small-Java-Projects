package com.boyko.wars;

import java.io.IOException;

public class CardVisualization {

    public static String drawCard(Card card, FileManagerInetrface fileManager) throws IOException {
        String pattern = fileManager.readFile();
        for (int i = 0; i < 2; i++) {
            pattern = pattern.contains("V") ? pattern.replaceAll("V", card.getValue())
                    : pattern.contains("S") ? pattern.replace("S", card.getSuit()) : pattern;
        }
        return pattern;
    }
}
