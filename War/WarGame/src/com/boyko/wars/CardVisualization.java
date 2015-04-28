package com.boyko.wars;


public class CardVisualization {

    private int[][] cardPattern = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 4, 2, 2, 2, 2, 1 }, { 1, 2, 2, 2, 2, 2, 1 },
            { 1, 2, 2, 2, 2, 2, 1 }, { 1, 2, 2, 3, 2, 2, 1 }, { 1, 2, 2, 2, 2, 2, 1 }, { 1, 2, 2, 2, 2, 2, 1 },
            { 1, 2, 2, 2, 2, 2, 1 }, { 1, 2, 2, 2, 2, 4, 1 }, { 1, 1, 1, 1, 1, 1, 1 }, };

    public CardVisualization(Card card) {
        for (int i = 0; i < cardPattern.length; i++) {
            for (int j = 0; j < cardPattern[0].length; j++) {

                String str = cardPattern[i][j] == 1 ? "*" : cardPattern[i][j] == 2 ? " "
                        : cardPattern[i][j] == 3 ? card.getSuit() : card.getValue();

                System.out.printf(" %s",str);
            }
            System.out.println();
        }
    }
}
