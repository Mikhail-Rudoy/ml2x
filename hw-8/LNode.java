import java.io.*;
import java.util.*;

public class LNode<E>
{
    private E data;
    private LNode<E> next;
    
    public LNode(E d)
    {
	data = d;
	next = null;
    }
    
    public E getData()
    {
	return data;
    }
    
    public void setData(E d)
    {
	data = d;
    }

    public LNode<E> getNext()
    {
	return next;
    }
    
    public void setNext(LNode<E> n)
    {
	next = n;
    }

    public String toString()
    {
	return data.toString();
    }
}