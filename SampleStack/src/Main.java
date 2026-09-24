public class Main {
    public static void main(String[] args){
        LinkedStack playerStack = new LinkedStack();
        playerStack.push(new Player(1, "Goku", 500));
        playerStack.push(new Player(2, "Saitama", 999));
        playerStack.push(new Player(3, "Deku", 100));
        playerStack.printStack();

        System.out.println("\n Popped Player: " + playerStack.pop());

        playerStack.printStack();

        System.out.println("\n Top Player: " + playerStack.peek());
    }
}
