import java.io.*;
import java.util.*;

public class DLNode<E>
{
    private E data;
    private DLNode<E> next;
    private DLNode<E> prev;
    
    public DLNode(E d, DLNode<E> n, DLNode<E> p)
    {
	data = d;
	next = n;
	prev = p;
    }
    public DLNode(E d)
    {
	this(d, null, null);
    }
    
    public E getData()
    {
	return data;
    }
    public void setData(E d)
    {
	data = d;
    }
    
    public DLNode<E> getNext()
    {
	return next;
    }
    public void setNext(DLNode<E> n)
    {
	next = n;
    }
    public DLNode<E> getPrev()
    {
	return prev;
    }
    public void setPrev(DLNode<E> n)
    {
	prev = n;
    }
}