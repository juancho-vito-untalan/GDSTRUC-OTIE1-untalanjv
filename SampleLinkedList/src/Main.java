public class Main {
    public static void main(String[] args){
        PlayerLinkedList playerList = new PlayerLinkedList();
        playerList.add(new Player(1, "Goku", 500));
        playerList.add(new Player(2, "Saitama", 999));
        playerList.add(new Player(3, "Sakamoto", 10));
        playerList.add(new Player(4, "Benjamin", 4));

        System.out.println(playerList.removeHead()); // returns and prints the reference to the node
        playerList.printList();
        System.out.println("Size of Linked List: " + playerList.getSize() + "\n");
        System.out.println("Contains Benjamin: " + playerList.contains(new Player(4, "Benjamin", 4)) + "\n");
        playerList.printListBackwards();
    }
}
