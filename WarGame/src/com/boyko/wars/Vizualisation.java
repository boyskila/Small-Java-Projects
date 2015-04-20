package com.boyko.wars;

public class Vizualisation {

    public Vizualisation() {

    }

    public static void battleViewOne(Player p1, Player p2, Card p1Card, Card p2Card) {

        System.out.printf("%d|%s ==> %s  VS   %s <== %s|%d%n", p1.wonCardsDeck.size(), p1.getName(), p1Card.toString(),
                p2Card.toString(), p2.getName(), p2.wonCardsDeck.size());

    }

    public static void battleViewTwo(Player p1, Player p2, Card p1Card, Card p2Card) {

        System.out.printf("%n     %s %d%n%n", p1.getName(), p1.wonCardsDeck.size());
        System.out.println(p1Card.printCard());
        System.out.println("       VS\n");
        System.out.println(p2Card.printCard());
        System.out.printf("     %s %d%n%n", p2.getName(), p2.wonCardsDeck.size());

    }

    public static void printPlayersCards(Player p1, Player p2) {

        System.out
                .println("========================================================================================================================");
        System.out.printf("%s's Cards %s%n", p1.getName(), p1.playerDeck.toString());
        System.out.printf("%s's Cards %s%n", p2.getName(), p2.playerDeck.toString());
        System.out
                .println("========================================================================================================================");
        System.out.println("\nPress Enter for new Cards\n");
    }

    public static void printResult(Player p1, Player p2) {

        String winner1 = "\n" + p1.getName().toUpperCase() + " WiN THE GAME\n\n" + p1.getName()
                + " is the winner with " + p1.wonCardsDeck.toString() + "\n\n" + p2.getName() + " have "
                + p2.wonCardsDeck.toString().toString();
        String winner2 = "\n" + p2.getName().toUpperCase() + " WiN THE GAME\n\n" + p2 + " is the winner with "
                + p2.wonCardsDeck.toString() + "\n\n" + p1.getName() + " have " + p1.wonCardsDeck.toString();
        String equalResult = "\nEqual Result\n\n" + p1 + " have " + p1.wonCardsDeck.toString() + "\n" + p2 + " have "
                + p2.wonCardsDeck.toString();

        System.out.println(p1.wonCardsDeck.size() < p2.wonCardsDeck.size() ? winner2
                : p1.wonCardsDeck.size() == p2.wonCardsDeck.size() ? equalResult : winner1);

    }
}
