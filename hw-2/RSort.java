import java.io.*;
import java.util.*;

public class RSort 
{
    /*======== public static int[] merge() ==========
      Inputs:  int[] a
               int[] b 
      Returns: 
               A new array of ints, containing all the elements of the 
	       2 parameter arrays, in ascending order.
      You can assume that the parameter arrays are both in
      ascending order.

      02/07/12 08:38:49
      jdyrlandweaver
      ====================*/
    public static int[] merge(int[] a, int[] b) 
    {
	
    }

    /*======== public static void swap() ==========
      Inputs:  int[] array
               int a
	       int b 
      Returns: 
             
      Swaps the elements at positions a and b in array array.
      A helper function to be used later on.

      02/07/12 08:40:42
      jdyrlandweaver
      ====================*/
    public static void swap(int[] array, int a, int b) 
    {
	int t = array[a];
	array[a] = array[b];
	array[b] = t;
    }

    /*======== public static void populate() ==========
      Inputs:  int[] a 
      Returns: 
      
      Populates an array of ints with random values

      02/07/12 08:42:40
      jdyrlandweaver
      ====================*/
    public static void populate(int[] a) 
    {
	Random r = new Random();
	for (int i=0; i < a.length; i++) 
	{
	    a[i] = (r.nextInt() % (a.length * 4));
	}
    }

    /*======== public static void insertionSort() ==========
      Inputs:  int[] a 
      Returns: 

      Uses the insertion sort algorithm to sort an array of
      ints into ascending order.

      02/07/12 08:43:20
      jdyrlandweaver
      ====================*/
    public static void insertionSort(int[] a) 
    {
	int t, pos;
	for (int i=1; i < a.length; i++) 
	{
	    pos = i;
	    t = a[pos];
	    while ( pos > 0 && a[pos - 1] > t ) 
	    {
		a[pos] = a[pos - 1];
		pos --;
	    }
	    a[pos] = t;
	}
    }

    /*======== public static void printArray() ==========
      Inputs:  int[] a 
      Returns: 
      
      Prtins out the contents of an array

      02/07/12 08:44:00
      jdyrlandweaver
      ====================*/
    public static void printArray(int[] a) 
    {
	for(int i=0; i<a.length; i++)
	{
	    System.out.print(a[i] + " ");
	}
	System.out.println();
    }


    public static void main(String[] args) 
    {
	int[] a = new int[5];
	int[] b = new int[5];
	int[] c;
	populate(a);
	populate(b);

	insertionSort(a);
	insertionSort(b);

	c = merge(a, b);
	
	printArray(a);
	printArray(b);
	printArray(c);
    }
}