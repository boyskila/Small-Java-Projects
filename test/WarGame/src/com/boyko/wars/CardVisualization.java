package com.boyko.wars;

import java.io.IOException;

public class CardVisualization {
    public CardVisualization(Card card) throws IOException {
        new FileManager(card);
    }
}
