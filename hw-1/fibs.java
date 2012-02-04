import java.lang.IllegalArgumentException;
import java.util.ArrayList;

public class fibs
{
    public static int fibR(int n)
    {
	if(n < 1)
	{
	    throw new IllegalArgumentException("non-positive input");
	}
	return (n<3) ? 1 : fibR(n-1) + fibR(n-2);
    }
    
    public static int fibA(int n)
    {
	if(n < 1)
        {
	    throw new IllegalArgumentException("non-positive input");
	}
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(1);
	list.add(1);
	return fibA(n, list);
    }

    public static int fibA(int n, ArrayList<Integer> list)
    {
	if(list.size() >= n)
	{
	    return list.get(n-1);
	}
	list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
	return fibA(n, list);
    }

    public static int fibO(int n)
    {
	if(n < 1)
	{
	    throw new IllegalArgumentException("non-positive input");
	}
	return fibO(n, 1, 1);
    }

    public static int fibO(int n, int a, int b)
    {
	return (n==1) ? b : fibO(n - 1, a + b, a);
    }

    public static void main(String[] args)
    {
	long s;
	System.out.println("fibR: recursive fibonacci");
	System.out.println("fibA: fibonacci using ArrayList");
	System.out.println("fibO: other fibonacci using only 2 terms at a time\n");
	for(int i = 1; i < 41; i++)
	{
	    s = System.nanoTime();
	    System.out.println("fibR(" + i + ") = " + fibR(i));
	    System.out.println("this took " + (System.nanoTime() - s) + " nano-seconds\n");
	    s = System.nanoTime();
	    System.out.println("fibA(" + i + ") = " + fibA(i));
	    System.out.println("this took " + (System.nanoTime() - s) + " nano-seconds\n");
	    s = System.nanoTime();
	    System.out.println("fibO(" + i + ") = " + fibO(i));
	    System.out.println("this took " + (System.nanoTime() - s) + " nano-seconds\n");
	}
    }
}