import java.util.EmptyStackException;

public class CardStack {
    private Card[] stack;
    private int top;

    public CardStack(int capacity) {
        stack = new Card[capacity];
        top = -1;
    }

    public void push(Card p) {
        // stack is already full
        if (top == stack.length - 1) {
            Card[] newStack = new Card[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[++top] = p;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getLength() {
        return stack.length;
    }

    public int countElements (){
        int count = 0;
        for (int i = top; i >= 0; i--) {
            count++;
        }
        return count;
    }

    public Card pop() {
        if (isEmpty())
            throw new EmptyStackException();

        Card poppedCard = stack[top];
        stack[top] = null;
        top--;
        return poppedCard;
    }

    public Card peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return stack[top];
    }

    public void printStack() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}