import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 917529042424017655L;
    private String name;
    private String password;
    private long bestResult;

    public Player(String name, String password, long bestResult) {
        this.name = name;
        this.password = password;
        this.bestResult = bestResult;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public long getBestResult() {
        return bestResult;
    }

    public void setBestResult(long bestResult) {
        this.bestResult = bestResult;
    }

}
