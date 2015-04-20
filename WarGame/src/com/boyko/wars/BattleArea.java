package com.boyko.wars;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BattleArea {

    private Deque<Card> cardsOfWar = new LinkedList<>();

    public BattleArea(Player p1, Player p2) {

        createBattle(p1, p2);
    }

    Scanner sc = new Scanner(System.in);

    public void createBattle(Player p1, Player p2) {

        String p1Name = p1.getName();
        String p2Name = p2.getName();

        Vizualisation.printPlayersCards(p1, p2);

        while (!p1.playerDeck.isEmpty()) {

            sc.nextLine();

            Card p1Card = p1.playerDeck.showCard();
            Card p2Card = p2.playerDeck.showCard();

            int card1Strenght = p1Card.getStrenght();
            int card2Strenght = p2Card.getStrenght();

            // Vizualisation.battleViewOne(player1, player2, p1Card, p2Card);
            Vizualisation.battleViewTwo(p1, p2, p1Card, p2Card);

            if (card1Strenght == card2Strenght) {

                createWar(p1, p2, p1Card, p2Card);

            } else {

                DeckOfWonCards winnerDeck = card1Strenght > card2Strenght ? p1.wonCardsDeck : p2.wonCardsDeck;
                String winnerName = card1Strenght > card2Strenght ? p1Name : p2Name;

                winnerDeck.takeCardsAfterWin(p1Card, p2Card);

                System.out.println("   -----------\n   " + "|" + winnerName + " win|\n" + "   -----------");

            }
            if (p1.wonCardsDeck.size() == p2.wonCardsDeck.size() && p1.playerDeck.isEmpty()
                    && p2.playerDeck.isEmpty()) {

                p1.playerDeck.loadThePlayerCardDeck(p1.wonCardsDeck.takeHelpingCard());
                p2.playerDeck.loadThePlayerCardDeck(p2.wonCardsDeck.takeHelpingCard());

            }
        }
        Vizualisation.printResult(p1, p2);
    }

    public void createWar(Player p1, Player p2, Card p1Card, Card p2Card) {

        int counter = 0;

        cardsOfWar.offer(p1Card);
        cardsOfWar.offer(p2Card);

        System.out.println("\n\n              WAR!!!\n");

        while (true) {

            sc.nextLine();

            if (p1.playerDeck.isEmpty() || p2.playerDeck.isEmpty()) {

                p1.playerDeck.loadThePlayerCardDeck(p1.wonCardsDeck.takeHelpingCard());
                p2.playerDeck.loadThePlayerCardDeck(p2.wonCardsDeck.takeHelpingCard());
            }

            p1Card = p1.playerDeck.showCard();
            p2Card = p2.playerDeck.showCard();

            int card1Strenght = p1Card.getStrenght();
            int card2Strenght = p2Card.getStrenght();

            cardsOfWar.offer(p1Card);
            cardsOfWar.offer(p2Card);

            Vizualisation.battleViewOne(p1, p2, p1Card, p2Card);

            if (++counter > 2) {

                if (card1Strenght == card2Strenght) {

                    continue;
                }

                DeckOfWonCards winnerCardDeck = card1Strenght > card2Strenght ? p1.wonCardsDeck
                        : p2.wonCardsDeck;
                String winnerName = card1Strenght > card2Strenght ? p1.getName() : p2.getName();

                winnerCardDeck.winnerLoop(cardsOfWar, winnerName);

                break;
            }
        }
    }
}
