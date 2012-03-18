import java.io.*;
import java.util.*;

public class ALQueue<Type>
{
    private ArrayList<Type> AL;
    
    public ALQueue()
    {
	AL = new ArrayList<Type>();
    }
    
    public void enqueue(Type o)
    {
	AL.add(o);
    }
    
    public Type dequeue()
    {
	return isEmpty() ? null : AL.remove(0);
    }
    
    public Type peek()
    {
	return isEmpty() ? null : AL.get(0);
    }
    
    public boolean isEmpty()
    {
	return AL.isEmpty();
    }
    
    public static void main(String[] args)
    {
	ALQueue<String> Q = new ALQueue<String>();
	System.out.println(Q.peek());
	Q.enqueue("hi");
	Q.enqueue("yo");
	System.out.println(Q.isEmpty());
	System.out.println(Q.peek());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.isEmpty());
    }
}
