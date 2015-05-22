import java.io.IOException;
import java.util.List;

public class PlayingRoom {
    private static final String FILE_NAME = "player.ser";

    public PlayingRoom() throws ClassNotFoundException, IOException {
        play();
    }

    private void play() throws ClassNotFoundException, IOException {
        List<Player> playersDataBase = GameMenager.getDataBase(FILE_NAME);
        GameMenager.printRating(playersDataBase);
        Player player = new PlayerService().SignInOrLogin(playersDataBase);
        new GameLogic().run(player);
        GameMenager.menageDataBase(playersDataBase, player, FILE_NAME);
        System.out.println("\nGame Over");
    }
}