import java.util.*;
import java.io.*;

public class DLListIterator<E> implements Iterator<E>
{
    DLNode<E> current;
    boolean canRemove;

    public DLListIterator(DLNode<E> l)
    {
	current = l;
	canRemove = false;
    }
    
    /*======== public boolean hasNext()) ==========
      Inputs:   
      Returns: true if there is at least one more element in the collection
      
      
      03/20/12 09:58:46
      jdyrlandweaver
      ====================*/
    public boolean hasNext()
    {
	return current.getNext().getNext() != null;
    }
    
    /*======== public E next()) ==========
      Inputs:   
      Returns: The next element in the collection

      Also moves the iterator forward by 1 element.
      Throws a NoSuchElement exception if there is
      no next element.

      03/20/12 09:59:16
      jdyrlandweaver
      ====================*/
    public E next()
    {
	if(!hasNext())
	{
	    throw new NoSuchElementException();
	}
	current = current.getNext();
	canRemove = true;
	return current.getData();
    }

    /*======== public void remove()) ==========
      Inputs:   
      Returns: 

      Removes the last element returned by next()
      Throws an IllegalStateException if next has
      not been called since the last time remove
      has been called.

      03/20/12 10:00:30
      jdyrlandweaver
      ====================*/
    public void remove()
    {
	if(!canRemove)
	{
	    throw new IllegalStateException();
	}
	canRemove = false;
	current = current.getPrev();
	current.setNext(current.getNext().getNext());
	current.getNext().setPrev(current);
    }
    
    public static void main(String[] args)
    {
	DLList<Integer> dl = new DLList<Integer>();  
	
	for (int i = 0; i < 20; i++)
	{ 
	    dl.add(i);
	}
	
	Iterator<Integer> i = dl.iterator();
	
	while (i.hasNext())
	{
	    System.out.print(i.next() + " ");
	}
	System.out.println();
	
	i = dl.iterator();
	
	while (i.hasNext())
	{
	    if (i.next() % 3 == 0)
	    { 
		i.remove();
	    }
	}
	System.out.println(dl);	
    }
}