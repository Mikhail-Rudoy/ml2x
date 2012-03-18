import java.util.*;

public class RSort 
{
    /*======== public static void quickSort() ==========
      Inputs:  int[] a
               int start
	       int end 
      Returns: 
      
      Performs an in-place quicksort. The general idea for the quicksort
      is to partition the list, then quicksort each partition.

      02/15/12 09:36:55
      jdyrlandweaver
      ====================*/
    public static void quickSort(int[] a, int start, int end)
    {
	if(start >= end)
	{
	    return;
	}
	int mid = partition(a, start, end);
	quickSort(a, start, mid);
	quickSort(a, mid + 1, end);
    }

    /*======== public static void quickSort() ==========
      Inputs:  int[] a
      
      Performs an in-place quicksort. The general idea for the quicksort
      is to partition the list, then quicksort each partition.

      02/15/12 09:36:55
      jdyrlandweaver
      ====================*/
    public static void quickSort(int[] a)
    {
	quickSort(a, 0, a.length - 1);
    }

    /*======== public static int partition() ==========
      Inputs:  int[] a
               int start
	       int end 
      Returns: The index of the end of the first partition

      
      Modifies array a such that every element in on the left is less
      than or equal to every element on the right.
      Only looks at the values between indicies start and end, inclusive.
      Should return the index that marks the end of the left (lesser)
      partition.
      02/15/12 09:38:01
      jdyrlandweaver
      ====================*/
    public static int partition(int[] a, int start, int end)
    {
	int s0 = start;
	int pivot = (a[start] + a[end] + a[(start + end) / 2]) / 3;
	for(;;)
	{
	    
	    while(start <= end && a[start] < pivot)
	    {
		start++;
	    }
	    while(start <= end && a[end] >= pivot)
	    {
	    	end--;
	    }
	    if(end == s0 - 1)
	    {
		return s0;
	    }
	    if(start > end)
	    {
		return end;
	    }
	    int i = a[start];
	    a[start] = a[end];
	    a[end] = i;
	    start++;
	    end--;
	}
    }

    /*======== public static int[] merge() ==========
      Inputs:  int[] a 
      Returns: 
               A new array of ints, containing all the elements of the 
	       parameter array, in ascending order.
      As I was not in class and minutia is not yet up, I do not know whether
      this is the desired solution.

      02/12/12 02:40:13
      mrudoy
      ====================*/
    public static int[] mergeSort(int[] a) 
    {
	if(a.length == 1)
	{
	    return a;
	}
	int mid = a.length / 2;
	int[] a1, a2;
	a1 = new int[mid];
	a2 = new int[a.length - mid];

	for(int i = 0; i < mid; i++)
	{
	    a1[i] = a[i];
	}
	for(int i = mid; i < a.length; i++)
	{
	    a2[i - mid] = a[i];
	}
	return merge(mergeSort(a1), mergeSort(a2));
    }

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
    int[] result = new int[a.length + b.length];
	int ai = 0; 
	int bi = 0;
	int i = 0;
	while(ai < a.length && bi < b.length)
	{
	    result[i++] = (a[ai] < b[bi]) ? a[ai++] : b[bi++];
	}
	int[] arr = (ai != a.length) ? a : b;
	int arri = (ai != a.length) ? ai : bi;
	while(arri < arr.length)
	{
	    result[i++] = arr[arri++];
	}
	return result;
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
	int[] c = new int[8];
	populate(a);
	populate(b);
	populate(c);

	insertionSort(a);
	insertionSort(b);

	System.out.println("merge(" + Arrays.toString(a) + ", " + Arrays.toString(b) + ") = " + Arrays.toString(merge(a, b)));	
	System.out.println("mergeSort(" + Arrays.toString(c) + ") = " + Arrays.toString(mergeSort(c)));
	System.out.println();

	c = new int[8];
	populate(c);
	System.out.println("partition: " + Arrays.toString(c) + "--" + partition(c, 0, 7) + "-->" + Arrays.toString(c));

	c = new int[15];
	populate(c);
	System.out.print("quickSort(" + Arrays.toString(c) + ") = ");
	quickSort(c);
	System.out.println(Arrays.toString(c));
    }
}