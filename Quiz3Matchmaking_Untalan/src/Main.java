import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();


    static int gameStart(ArrayQueue queue, int gameCount){
        System.out.println("\n" + "Game started! Dequeueing players!" + "\n");

        int playersToDequeue = 5;
        for (int i = 0; i < playersToDequeue; i++){
            queue.dequeue();
        }

        int playersNeeded = (5 - queue.size());

        if (playersNeeded < 0)
            playersNeeded = 0;

        System.out.println("Current Queue: ");
        queue.printQueue();
        System.out.println("\n" + "Number of players in queue: " + queue.size());
        System.out.println("Number of players needed to start: " + playersNeeded);
        return 1;
    }

    static void executeTurn(ArrayQueue queue){
        int randomNumber = rand.nextInt(7) + 1;

        for (int i = 0; i < randomNumber; i++){
            queue.enqueue(new Player (i, "Player " + i, (i+10)));
        }

        int playersNeeded = (5 - queue.size());

        if (playersNeeded < 0)
            playersNeeded = 0;
        System.out.println("Current Queue: ");
        queue.printQueue();
        System.out.println("\n" + "Number of players in queue: " + queue.size());
        System.out.println("Number of players needed to start: " + playersNeeded);
    }

    static void gameLoop(ArrayQueue queue){
        int gameCount = 0;

        while (gameCount < 10){
            System.out.println("Current Game Count: " + gameCount + "\n");
            promptEnterKey();
            executeTurn (queue);
            if (queue.size() >= 5){
                gameCount += gameStart (queue, gameCount);
            }
        }
    }

    public static void promptEnterKey() {
        System.out.println("Press ENTER to start next turn.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Blocks execution until the user presses Enter
    }

    public static void main(String[] args){
        int gameCount = 0;

        ArrayQueue queue = new ArrayQueue(7);

        gameLoop(queue);

        System.out.println("10 games have been started! Terminating program.");
    }
}
