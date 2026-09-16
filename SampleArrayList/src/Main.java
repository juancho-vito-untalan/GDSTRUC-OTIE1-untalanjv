import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player(1, "Goku", 500));
        playerList.add(new Player(2, "Saitama", 999));
        playerList.add(new Player(3, "Sakamoto", 10));

        System.out.println(playerList.get(1) + "\n");

        playerList.add(2, new Player(4, "Saiki K.", 100));

        Player removedPlayer = playerList.remove(1);
        System.out.println("Removed player: " + removedPlayer + "\n");

        boolean hasPlayer = playerList.contains(new Player(1, "Goku", 500));
        System.out.println("Player found: " + hasPlayer + "\n");

        int playerIndex = playerList.indexOf(new Player(4, "Saiki K.", 100));
        System.out.println("Player index: " + playerIndex + "\n");

        for (Player p : playerList) {
            System.out.println(p);
        }
    }
}