import java.io.*;
import java.util.*;

public class ALStack<T>
{
    private ArrayList<T> arrl;

    public ALStack()
    {
	arrl = new ArrayList<T>();
    }
    
    public void push(T o)
    {
	arrl.add(o);
    }

    public T pop()
    {
	return isEmpty() ? null : arrl.remove(arrl.size() - 1);
    }
    
    public T peek()
    {
	return isEmpty() ? null : arrl.get(arrl.size() - 1);
    }
    
    public boolean isEmpty()
    {
	return arrl.isEmpty();
    }
    
    public static void main(String[] args)
    {
	ALStack<String> stack = new ALStack<String>();
	System.out.println(stack.peek());
	stack.push("hi");
	stack.push("yo");
	System.out.println(stack.isEmpty());
	System.out.println(stack.peek());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.isEmpty());
    }
}