/*========== LList.java ==========
 
  An implementation of a simple linked list

  Note that all the methods are the same as the
  methods of ArrayList. They should exhibit the same 
  behavior as well.

  jdyrlandweaver
  =========================*/

import java.io.*;
import java.util.*;

public class LList<E>
{
    private LNode<E> first;
    private int size;
    
    /*======== public LList()) ==========
      Inputs:   
      Returns: 
      
      Initialize an empty list. 
      You can use a "dummy" node as the first element
      to make adding and removing easier.

      03/07/12 09:51:18
      jdyrlandweaver
      ====================*/
    public LList()
    {
	first = new LNode<E>( null );
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
	LNode<E> ln = new LNode<E>(data);
	LNode<E> current = first;
	while(current.getNext() != null)
	{
	    current = current.getNext();
	}
	current.setNext(ln);
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
	if(index < 0 || index >= size)
	{
	    throw new IndexOutOfBoundsException();
	}
	LNode<E> mynode = first.getNext();
	while(index != 0)
	{
	    mynode = mynode.getNext();
	    index = index - 1;
	}
	return mynode.getData();
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
	if(index < 0 || index >= size)
	{
	    throw new IndexOutOfBoundsException();
	}
	LNode<E> mynode = first.getNext();
	while(index != 0)
	{
	    mynode = mynode.getNext();
	    index = index - 1;
	}
	mynode.setData(data);
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
	String result = "( ";
	LNode<E> mynode = first;
	while(mynode.next != null)
	{
	    mynode = mynode.getNext();
	    result = result + mynode.toString() + " ";
	}
	return result + ")";
    }
    
    public static void main(String[] args)
    {
	
    }
}