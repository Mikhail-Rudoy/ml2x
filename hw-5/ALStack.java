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
	return isEmpty() ? null : arrl.remove(arrl.length - 1);
    }
    
    public T peek()
    {
	return isEmpty() ? null : arrl.get(arrl.length - 1);
    }
    
    public boolean isEmpty()
    {
	return arrl.isEmpty();
    }
    
    public static void main(String[] args)
    {
	
    }
}