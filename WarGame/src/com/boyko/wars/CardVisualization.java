package com.boyko.wars;

public class CardVisualization {
    private int[] cardPattern = { 1, 1, 1, 1, 1, 1, 1, 1, 4, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1,
            1, 2, 2, 3, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 4, 1, 1,
            1, 1, 1, 1, 1, 1 };

    public CardVisualization(Card card) {
        drawCard(card);
    }

    private void drawCard(Card card) {
        int i = 0;
        for (int j = 0; j < cardPattern.length; j++) {
            String str = cardPattern[j] == 1 ? "*" : cardPattern[j] == 2 ? " " : cardPattern[j] == 3 ? card.getSuit()
                    : card.getValue();
            if (++i == 7) {
                i = 0;
                System.out.printf(" %s%n", str);
            } else
                System.out.printf(" %s", str);
        }
    }
}
