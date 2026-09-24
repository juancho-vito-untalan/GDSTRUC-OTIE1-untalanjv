import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
    private LinkedList<Player> stack;

    public LinkedStack(){
        stack = new LinkedList<Player>();
    }

    public void push(Player p){
        stack.push(p);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public Player pop(){
        if(isEmpty())
            throw new EmptyStackException();

        return stack.pop();
    }

    public Player peek(){
        if (isEmpty())
            throw new EmptyStackException();

        return stack.peek();
    }

    public void printStack(){
        ListIterator<Player> listIterator = stack.listIterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
    }

}
