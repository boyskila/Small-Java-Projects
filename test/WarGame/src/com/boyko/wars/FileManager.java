package com.boyko.wars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    String filePath = "Card.txt";

    public FileManager(Card card) throws IOException {
        drawCard(this.filePath, card);
    }

    private void drawCard(String filePath, Card card) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                line = line.contains("1") ? line.replace("1", card.getValue()) : line.contains("2") ? line.replace("2",
                        card.getSuit()) : line;
                System.out.println(line);
                line = br.readLine();
            }
        }
    }
}
