import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    private String numberGenerator() {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Collections.shuffle(list);
        String a = list.get(0) + "";
        String b = list.get(1) + "";
        String c = list.get(2) + "";
        String d = list.get(3) + "";
        return sb.append(a + b + c + d).toString();
    }

    private void gameLogic(String secretNumber) {
        int moves = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            int bulls = 0;
            int cows = 0;
            System.out.print("Enter a  number: ");
            String guess = input.next();
            moves++;
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == secretNumber.charAt(i)) {
                    bulls++;
                } else if (secretNumber.contains(guess.charAt(i) + "")) {
                    cows++;
                }
            }
            if (bulls == 4) {
                break;
            } else {
                System.out.printf("%d cows && %d bulls%n", cows, bulls);
            }
        }
        System.out.printf("\nYou guess %s after %d moves%n", secretNumber, moves);
        input.close();
    }

    public void run(Player player) throws ClassNotFoundException, IOException {
        long start = System.currentTimeMillis();
        System.out.printf("Welcome %s%n", player.getName());
        String secretNumber = numberGenerator();
        gameLogic(secretNumber);
        Long endTime = GameMenager.stopWatch(start);
        if (player.getBestResult() > endTime) {
            player.setBestResult(endTime);
        }
    }
}
