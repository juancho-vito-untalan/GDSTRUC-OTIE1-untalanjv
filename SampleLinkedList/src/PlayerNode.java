public class PlayerNode {
    private Player player;
    private PlayerNode nextPlayer;
    private PlayerNode previousPlayer;

    public PlayerNode(Player player) {
        this.player = player;
    }

    public PlayerNode getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(PlayerNode nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerNode getPreviousPlayer() {
        return previousPlayer;
    }

    public void setPreviousPlayer(PlayerNode previousPlayer) {
        this.previousPlayer = previousPlayer;
    }
}