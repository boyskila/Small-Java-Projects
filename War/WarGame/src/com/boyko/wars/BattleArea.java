package com.boyko.wars;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BattleArea {

    private Deque<Card> cardsOfWar = new LinkedList<>();

    public BattleArea(DeckOfCards cardsDeck, Player p1, Player p2) {

        System.out.println(cardsDeck.toString() + "\n");

        while (!cardsDeck.isEmpty()) {

            p1.loadThePlayerCardDeck(cardsDeck.drawCard());
            p2.loadThePlayerCardDeck(cardsDeck.drawCard());

        }
        createBattle(p1, p2);
    }

    Scanner sc = new Scanner(System.in);

    public void createBattle(Player p1, Player p2) {

        Vizualisation.printPlayersCards(p1, p2);

        while (!p1.playerDeck.isEmpty()) {

            sc.nextLine();

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
                if (card1Strenght > card2Strenght) {
                    p1.takeCardsAfterWin(p1Card, p2Card);
                } else {
                    p2.takeCardsAfterWin(p1Card, p2Card);
                }

                String winnerName = card1Strenght > card2Strenght ? p1.getName() : p2.getName();

                System.out.println("   -----------\n   " + "|" + winnerName + " win|\n" + "   -----------");

            }
            if (p1.size() == p2.size() && p1.isEmpty() && p2.isEmpty()) {

                p1.loadThePlayerCardDeck(p1.takeHelpingCard());
                p2.loadThePlayerCardDeck(p2.takeHelpingCard());

            }
        }
        Vizualisation.printResult(p1, p2);
    }

    public void createWar(Player p1, Player p2) {

        int counter = 0;

        System.out.println("\n\n              WAR!!!\n");

        while (true) {

            sc.nextLine();

            if (p1.isEmpty() || p2.isEmpty()) {

                p1.takeHelpingCard();
                p2.takeHelpingCard();
            }

            Card p1Card = p1.showCard();
            Card p2Card = p2.showCard();

            int card1Strenght = p1Card.getStrenght();
            int card2Strenght = p2Card.getStrenght();

            cardsOfWar.offer(p1Card);
            cardsOfWar.offer(p2Card);

            Vizualisation.battleViewOne(p1, p2, p1Card, p2Card);

            if (++counter > 2) {

                if (card1Strenght == card2Strenght) {

                    continue;
                }
                String winnerName = card1Strenght > card2Strenght ? p1.getName() : p2.getName();

                if (card1Strenght > card2Strenght) {
                    p1.winnerLoop(cardsOfWar, winnerName);
                } else {
                    p2.winnerLoop(cardsOfWar, winnerName);
                }

                break;
            }
        }
    }
}
