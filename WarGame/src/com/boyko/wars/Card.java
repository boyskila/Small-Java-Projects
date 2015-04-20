package com.boyko.wars;

public class Card {

    private String suit;
    private String value;
    private int strenght;

    Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.strenght = cardStrenght(value);
    }

    public int cardStrenght(String card) {
        if (card.equals("A"))
            return 14;
        if (card.equals("K"))
            return 13;
        if (card.equals("Q"))
            return 12;
        if (card.equals("J"))
            return 11;
        if (card.equals("10"))
            return 10;
        if (card.equals("9"))
            return 9;
        if (card.equals("8"))
            return 8;
        if (card.equals("7"))
            return 7;
        if (card.equals("6"))
            return 6;
        if (card.equals("5"))
            return 5;
        if (card.equals("4"))
            return 4;
        if (card.equals("3"))
            return 3;
        if (card.equals("2"))
            return 2;

        return 0;

    }

    String[][] pattern = { { "  *", "*", "*", "*", "*", "*", "*" }, { "  *", "V", " ", " ", " ", " ", "*" },
            { "  *", " ", " ", " ", " ", " ", "*" }, { "  *", " ", " ", " ", "  ", "", "*" },
            { "  *", " ", " ", "S", " ", " ", "*" }, { "  *", " ", " ", " ", " ", " ", "*" },
            { "  *", " ", " ", " ", " ", " ", "*" }, { "  *", " ", " ", " ", " ", " ", "*" },
            { "  *", " ", " ", " ", " ", "V", "*" }, { "  *", "*", "*", "*", "*", "*", "*" }, };

    public String printCard() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[0].length; j++) {

                if (pattern[i][j].equals("V")) {
                    pattern[i][j] = value;

                } else if (pattern[i][j].equals("S")) {
                    pattern[i][j] = suit;
                }

                sb.append(pattern[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getStrenght() {
        return strenght;
    }

    @Override
    public String toString() {

        return value + suit;
    }

}
