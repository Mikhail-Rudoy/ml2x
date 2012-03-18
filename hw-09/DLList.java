/*========== DLList.java ==========

  An implementation of a doubly linked list

  Note that all the methods are the same as the
  methods of ArrayList. They should exhibit the same 
  behavior as well.

  jdyrlandweaver
  =========================*/

import java.io.*;
import java.util.*;

public class DLList<E>
{
    private DLNode<E> dummy;
    private DLNode<E> current;

    //index of the "current" node
    private int currentIndex;
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
	size = 0;
	dummy = new DLNode<E>(null);
	dummy.setNext(dummy);
	dummy.setPrev(dummy);
	current = dummy;
	currentIndex = -1;
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
	DLNode<E> penultimate = dummy.getPrev();
	penultimate.setNext(new DLNode<E>(data, dummy, penultimate));
	dummy.setPrev(penultimate.getNext());
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
	if(index < 0 || index > size)
	{
	    throw new IndexOutOfBoundsException();
	}
	while(currentIndex != index)
	{
	    if(currentIndex > index)
	    {
		currentIndex--;
		current = current.getPrev();
	    }
	    else
	    {
		currentIndex++;
		current = current.getNext();
	    }
	}
	
	current.getPrev().setNext(new DLNode<E>(data, current, current.getPrev()));
	current.setPrev(current.getPrev().getNext());
	size++;
	currentIndex++;
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
	if(index < 0 || index >= size)
	{
	    throw new IndexOutOfBoundsException();
	}
	while(currentIndex != index + 1)
	{
	    if(currentIndex > index + 1)
	    {
		currentIndex--;
		current = current.getPrev();
	    }
	    else
	    {
		currentIndex++;
		current = current.getNext();
	    }
	}
	
	E result = current.getPrev().getData();
	current.getPrev().getPrev().setNext(current);
	current.setPrev(current.getPrev().getPrev());
	size--;
	currentIndex--;
	return result;
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
	while(currentIndex != index)
	{
	    if(currentIndex > index)
	    {
		currentIndex--;
		current = current.getPrev();
	    }
	    else
	    {
		currentIndex++;
		current = current.getNext();
	    }
	}
	return current.getData();
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
	while(currentIndex != index)
	{
	    if(currentIndex > index)
	    {
		currentIndex--;
		current = current.getPrev();
	    }
	    else
	    {
		currentIndex++;
		current = current.getNext();
	    }
	}
	current.setData(data);
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
	String s = "[Circularly Linked Doubly Linked List] <-->";
	currentIndex = -1;
	int i = 0;
	for(current = dummy.getNext(); current != dummy; current = current.getNext())
	{
	    i++;
	    s = s + "[:" + current.getData().toString() + ":] <-->";
	    if(i == 5)
	    {
		s = s + "\n";
		i = 0;
	    }
	}
	s = s + "[end]";
	return s;
    }

    public static void main(String[] args)
    {
	DLList<String> list = new DLList<String>();
	System.out.println(list);
	list.add("hi");
	System.out.println(list);
	for(int i = 0; i < 26; i++)
	{
	    list.add("" + (char)('A' + i));
	}
	System.out.println(list);
	for(int i = 25; i >= 0; i--)
	{
	    list.add(i + 1, "" + (char)('A' + i));
	}
	System.out.println(list);
	for(int i = 0; i < 26; i++)
	{
	    list.add(3*i + 1,"" + (char)('A' + i));
	}
	System.out.println(list);
	for(int i = 0; i < 26; i++)
	{
	    list.remove(2*i + 1);
	}
	System.out.println(list);
	for(int i = 0; i < 26; i++)
	{
	    list.set(2*i + 2, "" + (char)('a' + i));
	}
	System.out.println(list);
	for(int i = 0; i < list.size(); i++)
	{
	    System.out.print(list.get(i));
	}
	System.out.println();
    }
}