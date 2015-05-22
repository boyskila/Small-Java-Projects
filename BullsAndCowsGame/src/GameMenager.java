import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class GameMenager {
    public static void getRaiting(List<Player> playersDataBase) {
        List<Player> sortedPlayers = playersDataBase.stream()
                .sorted((player1, player2) -> Long.compare(player1.getBestResult(), player2.getBestResult()))
                .collect(Collectors.toList());
        printRating(sortedPlayers);
    }

    public static void printRating(List<Player> sortedPlayers) {
        int counter = 0;
        for (Player player : sortedPlayers) {
            long minutes = TimeUnit.MILLISECONDS.toMinutes(player.getBestResult()) % 60;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(player.getBestResult()) % 60;
            counter++;
            String variantA = String.format("%d place: %s time: 0%d:0%d", counter, player.getName(), minutes, seconds);
            String variantB = String.format("%d place: %s time 0%d:%d", counter, player.getName(), minutes, seconds);
            String choosenVariant = seconds < 10 && minutes < 10 ? variantA : seconds > 10 && minutes < 10 ? variantB
                    : variantA;
            System.out.println(choosenVariant);
        }
    }

    private static void printTime(long time) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time) % 60;
        String variantA = String.format("time: 0%d:0%d%n", minutes, seconds);
        String variantB = String.format("time 0%d:%d%n", minutes, seconds);
        String choosenVariant = seconds < 10 && minutes < 10 ? variantA : seconds > 10 && minutes < 10 ? variantB
                : variantA;
        System.out.println(choosenVariant);
    }

    public static Long stopWatch(long start) {
        long time = System.currentTimeMillis() - start;
        printTime(time);
        return time;
    }

    public static List<Player> getDataBase(String fileName) throws ClassNotFoundException, IOException {
        Path path = Paths.get(fileName);
        return Files.exists(path) ? FileMenager.deserialize(fileName) : null;
    }

    public static void menageDataBase(List<Player> playersDataBase, Player player, String fileName) throws IOException {
        playersDataBase.remove(player);
        playersDataBase.add(player);
        FileMenager.serialize(playersDataBase, fileName);
        GameMenager.getRaiting(playersDataBase);
    }
}
