import java.io.*;
import java.util.*;
import java.lang.*;

public class BSTreeNode<T extends Comparable<? super T>> 
    implements Comparable<BSTreeNode<T>>
{
    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;
    
    public BSTreeNode(T d)
    {
 	data = d;
	left = null;
	right = null;
    }
    
    //accessors
    public T getData()
    {
	return data;
    }
    public BSTreeNode<T> getLeft()
    {
	return left;
    }
    public BSTreeNode<T> getRight()
    {
	return right;
    }
    
    //mutators
    public void setData(T d)
    {
	data = d;
    }
    public void setLeft(BSTreeNode<T> l)
    {
	left = l;
    }
    public void setRight(BSTreeNode<T> r)
    {
	right = r;
    }
    
    //compareTo
    public int compareTo(BSTreeNode<T> other)
    {
	return data.compareTo(other.getData());
    }
}