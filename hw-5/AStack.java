import java.io.*;
import java.util.*;

public class AStack<T>
{
    private int top;
    private T[] arr;
    
    public AStack() 
    {
	top = 0;
	arr = (T[])(new Object[5]);
    }
    
    public AStack(T[] src)
    {
	top = src.length;
	arr = (T[])(new Object[2 * src.length + 5]);
	for(int i = 0; i < src.length; i++)
	{
	    arr[i] = src[i];
	}
    }
    
    public void push(T o)
    {
	if(top == arr.length)
	{
	    expand();
	}
	arr[top++] = o;
    }
    
    public T pop()
    {
	T o = peek();
	top = isEmpty() ? 0 : top - 1;
	return o;
    }
    
    public T peek()
    {
	return isEmpty() ? null : arr[top - 1];
    }
    
    public boolean isEmpty()
    {
	return top == 0;
    }
    
    private void expand() 
    {
	T[] n = (T[])(new Object[arr.length * 2 + 1]);
	for(int i = 0; i < arr.length; i++)
	{
	    n[i] = arr[i];
	}
	arr = n;
    }

    public static void main(String[] args) 
    {
	AStack<String> stack = new AStack<String>();
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