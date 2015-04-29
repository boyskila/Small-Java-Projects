package com.boyko.wars;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BattleArea {

    private Deque<Card> cardsOfWar = new LinkedList<>();

    public BattleArea(DeckOfCards cardsDeck, Player p1, Player p2) {
        start(cardsDeck, p1, p2);
    }

    Scanner sc = new Scanner(System.in);
    int counter = 0;

    private void start(DeckOfCards cardsDeck, Player p1, Player p2) {
        System.out.println(cardsDeck.toString() + "\n");
        for (int i = 0; i < 26; i++) {
            p1.getCard(cardsDeck.sendCard());
            p2.getCard(cardsDeck.sendCard());
        }
        createBattle(p1, p2);
    }

    private void createBattle(Player p1, Player p2) {
        Vizualisation.printPlayersCards(p1, p2);
        while (true) {
            // sc.nextLine();
            Card p1Card = p1.showCard();
            Card p2Card = p2.showCard();
            int card1Strenght = p1Card.getStrenght();
            int card2Strenght = p2Card.getStrenght();
            // Vizualisation.battleViewOne(p1, p2, p1Card, p2Card);
            Vizualisation.battleViewTwo(p1, p2, p1Card, p2Card);
            if (card1Strenght == card2Strenght) {
                cardsOfWar.offer(p1Card);
                cardsOfWar.offer(p2Card);
                createWar(p1, p2);
            } else {
                Player winner = card1Strenght > card2Strenght ? p1 : p2;
                winner.getCard(p1Card);
                winner.getCard(p2Card);
                System.out.println("   -----------\n   " + "|" + winner.getName() + " win|\n" + "   -----------");
            }
            if (++counter >= 26)
                break;
        }
        Vizualisation.printResult(p1, p2);
    }

    private void createWar(Player p1, Player p2) {
        int cardCounter = 0;
        System.out.println("\n\n              WAR!!!\n");
        while (true) {
            // sc.nextLine();
            counter++;
            Card p1Card = p1.showCard();
            Card p2Card = p2.showCard();
            int card1Strenght = p1Card.getStrenght();
            int card2Strenght = p2Card.getStrenght();
            cardsOfWar.offer(p1Card);
            cardsOfWar.offer(p2Card);
            Vizualisation.battleViewOne(p1, p2, p1Card, p2Card);
            if (++cardCounter > 2) {
                if (card1Strenght == card2Strenght)
                    continue;
                Player winner = card1Strenght > card2Strenght ? p1 : p2;
                winner.getAllCards(cardsOfWar, winner.getName());
                break;
            }
        }
    }
}
