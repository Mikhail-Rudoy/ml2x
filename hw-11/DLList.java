/*========== DLList.java ==========

  An implementation of a doubly linked list

  Note that all the methods are the same as the
  methods of ArrayList. They should exhibit the same 
  behavior as well.

  jdyrlandweaver
  =========================*/

import java.io.*;
import java.util.*;

public class DLList<E> implements Iterable<E>
{
    //the beginning of the list
    private DLNode<E> first;
    //the end of the list
    private DLNode<E> last;
    
    private int size;
    
    /*======== public DLList()) ==========
      Inputs:   
      Returns: 
      
      Initialize an empty list. 
      You can use "dummy" nodes if you like
      
      03/07/12 09:51:18
      jdyrlandweaver
      ====================*/
    public DLList()
    {
	first = new DLNode<E>(null); 
	last = new DLNode<E>(null);
	
	first.setNext(last);
	last.setPrev(first);
	size = 0;
    }
    
    /*======== public void add() ==========
      Inputs:   E data  
      Returns: 

      Adds a node containing data to the end of the list
      
      03/07/12 09:52:29
      jdyrlandweaver
      ====================*/
    public void add(E data)
    {
	DLNode<E> n = new DLNode<E>(data);
	
	last.getPrev().setNext(n);
	n.setPrev(last.getPrev());
	n.setNext(last);
	last.setPrev(n);
	
	size++;
    }

    /*======== public void add() ==========
      Inputs:   int index
                E data  
      Returns: 
      
      Adds a node containing data to position index.
      If index < 0 or index > size throw an IndexOutOfBoundsException
      To throw an index, just use the following line:
          throw new IndexOutOfBoundsException()

      03/07/12 09:53:34
      jdyrlandweaver
      ====================*/
    public void add(int index, E data)
    {
	if (index < 0 || index > size)
	{
	    throw new IndexOutOfBoundsException();
	}
	
	DLNode<E> n = new DLNode<E>(data);
	DLNode<E> curr = first;
	
	for (int i = 0; i < index; i++)
	{ 
	    curr = curr.getNext();
	}
	
	n.setPrev(curr);
	n.setNext(curr.getNext());
	curr.setNext(n);
	n.getNext().setPrev(n);
	size++;
    }
    
    /*======== public E remove() ==========
      Inputs:   int index  
      Returns: The data at index 

      Removes the node at index from the list and returns
      the data contained in that node

      If index < 0 or index >= size throws an IndexOutOfBoundsException

      03/07/12 09:56:10
      jdyrlandweaver
      ====================*/
    public E remove(int index)
    {
	if (index < 0 || index >= size)
	{
	    throw new IndexOutOfBoundsException();
	}
	
	DLNode<E> curr = first;
	
	for (int i = 0; i < index; i++)
	{ 
	    curr = curr.getNext();
	}
	
	E tmp = curr.getNext().getData();
	
	curr.setNext(curr.getNext().getNext());
	curr.getNext().setPrev(curr);
	
	size--;
	return tmp;
    }
    
    /*======== public E get() ==========
      Inputs:   int index  
      Returns: The data at index

      If index < 0 or index >= size throws an IndexOutOfBoundsException

      03/07/12 09:57:16
      jdyrlandweaver
      ====================*/
    public E get(int index)
    {
	if (index < 0 || index >= size)
	{
	    throw new IndexOutOfBoundsException();
	}
	
	DLNode<E> curr = first;
	
	for (int i = 0; i <= index; i++)
	{ 
	    curr = curr.getNext();
	}
	
	return curr.getData();
    }

    /*======== public void set() ==========
      Inputs:   int index
                E data  
      Returns: 

      Changes the node at index to contain data

      If index < 0 or index >= size throws an IndexOutOfBoundsException

      03/07/12 09:57:42
      jdyrlandweaver
      ====================*/
    public void set(int index, E data)
    {
	if (index < 0 || index >= size)
	{
	    throw new IndexOutOfBoundsException();
	}
	
	DLNode<E> curr = first;
	
	for (int i = 0; i <= index; i++)
	{ 
	    curr = curr.getNext();
	}
	
	curr.setData(data);
    }
    
    /*======== public int size()) ==========
      Inputs:   
      Returns: The number of elements in the list


      03/07/12 09:58:29
      jdyrlandweaver
      ====================*/
    public int size()
    {
	return size;
    }
    
    public String toString()
    {
	DLNode<E> curr = first.getNext();
	String s = "";
	
	while (curr.getNext() != null)
	{
	    s+= curr.getData() + " ";
	    curr = curr.getNext();
	}
	
	return s;
    }
    
    public DLListIterator<E> iterator()
    {
	return new DLListIterator<E>(first);
    }
    
    public static void main(String[] args)
    {
	DLList<Integer> l = new DLList<Integer>();
	
	System.out.println(l);
	
	for (int i = 0; i < 5; i++)
	{ 
	    l.add( i );
	}
	
	System.out.println(l + "\t" + l.size());
	
	
	l.add(0, 100);
	
	System.out.println(l + "\t" + l.size());
	l.add(6, 200);
	System.out.println(l + "\t" + l.size());
	l.add(3, 300);
	System.out.println(l + "\t" + l.size());
	
	l.remove(3);
	System.out.println(l + "\t" + l.size());
	l.remove(0);
	System.out.println(l + "\t" + l.size());
	l.remove(l.size() - 1);
	System.out.println(l + "\t" + l.size());
    }
}