public class Main {
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue(new Player(1, "Goku", 500));
        queue.enqueue(new Player(2, "Saitama", 999));
        queue.enqueue(new Player(3, "Deku", 100));

        queue.printQueue();

        System.out.println("\nRemoving Player " + queue.dequeue());
        System.out.println("\nCurrent Front " + queue.peek());

        queue.enqueue(new Player(4, "Saiki K.", 200));
        System.out.println("\n");
        queue.printQueue();
    }
}
