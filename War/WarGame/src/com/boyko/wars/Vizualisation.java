package com.boyko.wars;

public class Vizualisation {

    public Vizualisation() {

    }

    public static void battleViewOne(Player p1, Player p2, Card p1Card, Card p2Card) {

        System.out.printf("%d|%s ==> %s  VS   %s <== %s|%d%n", p1.size(), p1.getName(), p1Card.toString(),
                p2Card.toString(), p2.getName(), p2.size());

    }

    public static void battleViewTwo(Player p1, Player p2, Card p1Card, Card p2Card) {

        System.out.printf("%n     %s %d%n%n", p1.getName(), p1.size());
        new CardVisualization(p1Card);
        System.out.println("       VS\n");
        new CardVisualization(p2Card);
        System.out.printf("     %s %d%n%n", p2.getName(), p2.size());

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
                + " is the winner with " + p1.toString() + "\n\n" + p2.getName() + " have " + p2.toString().toString();
        String winner2 = "\n" + p2.getName().toUpperCase() + " WiN THE GAME\n\n" + p2.getName()
                + " is the winner with " + p2.toString() + "\n\n" + p1.getName() + " have " + p1.toString();
        String equalResult = "\nEqual Result\n\n" + p1.getName() + " have " + p1.toString() + "\n" + p2.getName()
                + " have " + p2.toString();

        System.out.println(p1.size() < p2.size() ? winner2 : p1.size() == p2.size() ? equalResult : winner1);

    }
}
