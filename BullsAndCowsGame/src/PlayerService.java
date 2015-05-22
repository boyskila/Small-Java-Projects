import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PlayerService {
    Scanner sc = new Scanner(System.in);

    public Player SignInOrLogin(List<Player> playersDataBase) throws ClassNotFoundException, IOException {
        System.out.println("Choose 1 for registration and 2 for login");
        String option = sc.next();
        switch (option) {
            case "1":
                return signIn(playersDataBase);
            case "2":
                return login(playersDataBase);
            default:
                return new Player("Defaulth Player", "", Long.MAX_VALUE);
        }
    }

    private Player signIn(List<Player> playersDataBase) throws IOException, ClassNotFoundException {
        System.out.println("Please sign in\n");
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        Player p = passPlayer(playersDataBase, name, password);
        if (p != null) {
            System.out.println("There is a player with same name and password");
            System.out.println("Try again");
            signIn(playersDataBase);
        }
        return new Player(name, password, Long.MAX_VALUE);
    }

    private Player login(List<Player> playersDataBase) throws ClassNotFoundException, IOException {
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        Player player = passPlayer(playersDataBase, name, password);
        return player != null ? player : SignInOrLogin(playersDataBase);
    }

    private Player passPlayer(List<Player> list, String name, String password) throws ClassNotFoundException,
            IOException {
        for (Player player : list) {
            if (player.getName().equals(name) && player.getPassword().equals(password)) {
                return player;
            }
        }
        return null;
    }
}
