package com.boyko.wars;

import java.io.IOException;
import java.util.Scanner;

public class Vizualisation {

    public static void battleViewOne(Player p1, Player p2, Card p1Card, Card p2Card) {
        System.out.printf("%d|%s ==> %s  VS   %s <== %s|%d%n", p1.deckSize(), p1.getName(), p1Card.toString(),
                p2Card.toString(), p2.getName(), p2.deckSize());
    }

    public static void battleViewTwo(Scanner sc, Player p1, Player p2, Card p1Card, Card p2Card) throws IOException {
        System.out.printf("%n     %s %d%n%n", p1.getName(), p1.deckSize());
        new FileManager(p1Card);
        System.out.println("       VS\n");
        sc.nextLine();
        new FileManager(p2Card);
        System.out.printf("     %s %d%n%n", p2.getName(), p2.deckSize());
    }

    public static void printPlayersCards(Player p1, Player p2) {
        System.out.printf("%s %s%n", p1.getName(), p1.toString());
        System.out.printf("%s %s%n", p2.getName(), p2.toString());
        System.out.println("\nPress Enter for new Cards\n");
    }

    public static void printResult(Player p1, Player p2) {
        Player loser = p1.deckSize() < p2.deckSize() ? p1 : p2;
        Player winner = p1.deckSize() < p2.deckSize() ? p2 : p1;
        String winnerName = winner.getName().toUpperCase();
        if (p1.deckSize() == p2.deckSize()) {
            System.out.println("Equal Result");
            System.out.printf("%s have %s%n", p1.getName(), p1.toString());
            System.out.printf("%s have %s ", p2.getName(), p2.toString());
        } else {
            System.out.printf("%n%s WIN THE GAME%n%n", winnerName);
            System.out.printf("%s is the winner with %s%n%n", winnerName, winner.toString());
            System.out.printf("%s have %s ", loser.getName(), loser.toString());
        }
    }
}
