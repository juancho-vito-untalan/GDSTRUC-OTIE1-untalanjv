import java.util.Random;
import java.util.Scanner;

public class Main {
    Random rand = new Random();

    void playerTurn(CardStack playerHand, CardStack playerDeck, CardStack discardPile){
        System.out.println("Cards left in deck: " + playerDeck.countElements());
        System.out.println("Cards in Discard Pile: " + discardPile.countElements());
        System.out.println("Cards in Player Hand: " + playerHand.countElements());
        System.out.println("Player Hand: ");
        playerHand.printStack();
        promptEnterKey();

        generateCommand(playerHand, playerDeck, discardPile);
    }

    void fillDeck(CardStack playerDeck){
        for (int i = 0; i < playerDeck.getLength(); i++){
            Card card = new Card("Card " + (i + 1));
            playerDeck.push(card);
        }
    }

    void generateCommand(CardStack playerHand, CardStack playerDeck, CardStack discardPile){
        int randomNumber = rand.nextInt(3) + 1; // generates random from 1-3 for which command

        switch(randomNumber) {
            case 1:
                drawFromDeck(playerDeck, playerHand);
                break;
            case 2:
                discardCards(playerHand, discardPile);
                break;
            case 3:
                drawFromDiscardPile(discardPile, playerHand);
                break;
        }
    }

    void drawFromDeck(CardStack playerDeck, CardStack playerHand){
        System.out.println("COMMAND: DRAW FROM DECK!");

        if (playerDeck.isEmpty()){
            System.out.println("Failed! Deck is empty!");
            return;
        }

        int randomNumber = rand.nextInt(5) + 1; // generates random from 1-5 for number of cards

        if (playerDeck.countElements() < randomNumber){
            randomNumber = playerDeck.countElements();
        }

        System.out.println("Drawing " + randomNumber + " cards from the deck...");

        for (int i = 0; i < randomNumber; i++) {
            playerHand.push(playerDeck.pop()); // pushes top card of playerDeck to playerHand
        }
    }

    void discardCards(CardStack playerHand, CardStack discardPile){
        System.out.println("COMMAND: DISCARD!");

        if (playerHand.isEmpty()){
            System.out.println("Failed! Player Hand is empty!");
            return;
        }

        int randomNumber = rand.nextInt(5) + 1; // generates random from 1-5 for number of cards

        if (playerHand.countElements() < randomNumber){
            randomNumber = playerHand.countElements();
        }

        System.out.println("Discarding " + randomNumber + " cards from your hand...");

        for (int i = 0; i < randomNumber; i++){
            discardPile.push(playerHand.pop()); // pops from playerHand and pushes to discardPile
        }
    }

    void drawFromDiscardPile(CardStack discardPile, CardStack playerHand){
        System.out.println("COMMAND: DRAW FROM DISCARD PILE!");

        if (discardPile.isEmpty()){
            System.out.println("Failed! Discard Pile is empty!");
            return;
        }

        int randomNumber = rand.nextInt(5) + 1; // generates random from 1-5 for number of cards

        if (discardPile.countElements() < randomNumber){
            randomNumber = discardPile.countElements();
        }

        System.out.println("Drawing " + randomNumber + " cards from the discard pile...");

        for (int i = 0; i < randomNumber; i++){
            playerHand.push(discardPile.pop()); // pops from discardPile and pushes to playerHand
        }
    }

    void gameLoop(CardStack playerHand, CardStack playerDeck, CardStack discardPile){
        while (!playerDeck.isEmpty()){
            playerTurn(playerHand, playerDeck, discardPile);
        }
    }

    public static void promptEnterKey() {
        System.out.println("Press ENTER to start next turn.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Blocks execution until the user presses Enter
    }


    public static void main (String[] args){
        Main game = new Main(); // i added this cause i looked up why my fillDeck and gameLoop were erroring

        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(5);
        CardStack discardPile = new CardStack(30);

        game.fillDeck(playerDeck);
        game.gameLoop(playerHand, playerDeck, discardPile);

        System.out.println("GAME OVER! Deck is now empty!");
        System.out.println("Cards in Discard Pile: " + discardPile.countElements());
        System.out.println("Cards in Player Hand: " + playerHand.countElements());
    }
}
