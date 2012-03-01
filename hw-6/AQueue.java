import java.io.*;
import java.util.*;

public class AQueue<Type>
{
    private Type[] arr;
    private int front;
    private int back;

    public AQueue()
    {
	arr = (Type[])(new Object[5]);
	front = 0;
	back = 0;
    }
    
    public void enqueue(Type o)
    {
	arr[back] = o;
	back = (back + 1) % arr.length;
	if(back == front)
	{
	    expand();
	}
    }
    
    public Type dequeue()
    {
	if(isEmpty())
	{
	    return null;
	}
	Type t = arr[front];
	arr[front] = null;
	front = (front + 1) % arr.length;
	return t;
    }
    
    public Type peek()
    {
	return isEmpty() ? null : arr[front];
    }
    
    public boolean isEmpty()
    {
	return front == back;
    }
    
    private void expand()
    {
	Type[] n = (Type[])(new Object[arr.length * 2 + 1]);
	back = arr.length;
	for(int i = 0; i < arr.length; i++)
	{
	    n[i] = arr[(front + i) % arr.length];
	}
	arr = n;
	front = 0;
    }
    
    public static void main(String[] args)
    {
	AQueue<String> Q = new AQueue<String>();
	System.out.println(Q.peek());
	Q.enqueue("hi");
	Q.enqueue("yo");
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	Q.enqueue("hello");
	Q.enqueue("people");
	Q.enqueue("blah");
	Q.enqueue("Blah");
	Q.enqueue("BLAH");
	Q.enqueue("I");
	Q.enqueue("need");
	Q.enqueue("lots");
	Q.enqueue("of");
	Q.enqueue("elements");
	Q.enqueue("to");
	Q.enqueue("test");
	Q.enqueue("expanding");
	Q.enqueue(".");
	System.out.println(Q.isEmpty());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.dequeue());
	System.out.println(Q.peek());
	System.out.println(Q.isEmpty());
    }
}