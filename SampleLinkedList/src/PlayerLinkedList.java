public class PlayerLinkedList {
    private PlayerNode head;

    public void add(Player player) {
        PlayerNode node = new PlayerNode(player);
        node.setNextPlayer(head);

        if (head!= null) { // only sets previous if there's already a head
            head.setPreviousPlayer(node); // sets the old head to the previous node of the current head
        }

        head = node;
    }

    public PlayerNode removeHead() {
        PlayerNode removedNode = head;

        head = head.getNextPlayer();

        if (head != null) { // if there r still items in the list, make previous player null to clean up
            head.setPreviousPlayer(null);
        }

        return removedNode;
    }

    public int getSize(){
        PlayerNode currentNode = head;
        int count = 0;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNextPlayer();
        }
        return count;
    }

    public boolean contains(Player player){
        PlayerNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.getPlayer().equals(player)){ // I had to look up why == wasn't working
                return true;
            }
            currentNode = currentNode.getNextPlayer();
        }
        return false;
    }

    public void printList() {
        PlayerNode currentNode = head;

        System.out.println("HEAD ");

        while (currentNode != null){
            System.out.println(" -> " + currentNode.getPlayer());
            currentNode = currentNode.getNextPlayer();
        }
    }

    public void printListBackwards() {
        PlayerNode currentNode = head;

        System.out.println("TAIL ");

        while (currentNode.getNextPlayer() != null){ // iterates through entire list
            currentNode = currentNode.getNextPlayer();
        }

        while (currentNode != null){ //
            System.out.println(" -> " + currentNode.getPlayer());
            currentNode = currentNode.getPreviousPlayer();
        }
    }

}
