import java.io.*;
import java.util.*;
import java.lang.*;

public class BSTree <T extends Comparable<? super T>>
{
    public BSTreeNode<T> root;
    
    public BSTree()
    {
	root = null;
    }
    
    public boolean isEmpty()
    {
	return root == null;
    }
    public boolean isLeaf(BSTreeNode<T> t)
    {
	return (t.getLeft() == null && t.getRight() == null);
    }
    
    public void add(T c)
    {
	root = add(root, new BSTreeNode<T>(c));
    }
    
    public BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t)
    {
	if(curr == null)
	{
	    return t;
	}
	
	if(t.compareTo(curr) >= 0)
	{
	    curr.setRight(add(curr.getRight(), t));
	}
	else
	{
	    curr.setLeft(add(curr.getLeft(), t));
	}
	return curr;
    }
    
    public void inOrder()
    {
	inOrderHelper(root);
	System.out.println();
    }
    
    public void inOrderHelper(BSTreeNode<T> t)
    {
	if (t == null)
	{ 
	    return;
	}
	inOrderHelper(t.getLeft());
	System.out.print(t.getData() + " ");
	inOrderHelper(t.getRight());
    }
    
    public void remove(T c)
    {
	remove(c, root, null, true);
    }
    
    public void remove(T c, BSTreeNode<T> curr, BSTreeNode<T> parent, boolean rightchild)
    {
	if(curr == null)
	{
	    return;
	}
	int compare = curr.getData().compareTo(c);
	if(compare > 0)
	{
	    remove(c, curr.getLeft(), curr, false);
	}
	else if(compare < 0)
	{
	    remove(c, curr.getRight(), curr, true);
	}
	else
	{
	    if(parent == null)
	    {
		root = null;
	    }
	    if(curr.getRight() == null)
	    {
		if(rightchild)
		{
		    parent.setRight(curr.getLeft());
		}
		else
		{
		    parent.setLeft(curr.getLeft());
		}
		return;
	    }
	    if(curr.getLeft() == null)
	    {
		if(rightchild)
		{
		    parent.setRight(curr.getRight());
		}
		else
		{
		    parent.setLeft(curr.getRight());
		}
		return;
	    }
	    BSTreeNode<T> useful = curr.getRight();
	    while(useful.getLeft() != null)
	    {
		useful = useful.getLeft();
	    }
	    useful.setLeft(curr.getLeft());
	    if(rightchild)
	    {
		parent.setRight(curr.getRight());
	    }
	    else
	    {
		parent.setLeft(curr.getRight());
	    }
	}
    }
    
    public static void main(String[] args)
    {
	BSTree<Integer> b = new BSTree<Integer>();
	ArrayList<Integer> source = new ArrayList<Integer>();
	for (int i = 0; i < 10; i++)
	{
	    source.add(i);
	}
	for(; !source.isEmpty(); b.add(source.remove((int)(Math.random() * source.size()))));
	b.inOrder();
	for(int i = 5; i < 9; i++)
	{
	    b.remove(i);
	    b.inOrder();
	}
    }
}