import java.io.*;
import java.util.*;


public class BTree<E>
{
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    private BTreeNode<E> root;

    public BTree()
    {
        root = null;
    }
    
    public void add(E d)
    {
        BTreeNode<E> bn = new BTreeNode<E>(d);
        if (root == null)
        {
            root = bn;
        }
        else
        {
            add(root, bn);
        }
    }
    
    public void add(BTreeNode<E> curr, BTreeNode<E> bn)
    {
	if (curr.getLeft() == null)
        {
            curr.setLeft(bn);
        }
        else if(curr.getRight() == null)
        {
            curr.setRight(bn);
        }
	else if ((int)(Math.random() * 2) == 0)
        {
            add(curr.getLeft(), bn);
        }
        else 
        {
            add(curr.getRight(), bn);
        }
    }
    
    public void traverse(int mode)
    {
	if (mode == PRE_ORDER)
        {
            preOrder(root);
        }
        else if (mode == IN_ORDER)
        {
            inOrder(root);
        }
        else
        {
            postOrder(root);
        }
        System.out.println();
    }
    
    public void preOrder(BTreeNode<E> curr)
    {
	if (curr != null)
        {
	    System.out.print(curr.getData() + " ");
            preOrder(curr.getLeft());
            preOrder(curr.getRight());
        }
    }

    public void inOrder(BTreeNode<E> curr)
    {
	if (curr != null)
        {
            inOrder(curr.getLeft());
	    System.out.print(curr.getData() + " ");
            inOrder(curr.getRight());
        }
    }

    public void postOrder(BTreeNode<E> curr)
    {
	if (curr != null)
        {
            postOrder(curr.getLeft());
            postOrder(curr.getRight());
	    System.out.print(curr.getData() + " ");
        }
    }
    
    public int getHeight()
    {
        return getHeight(root);
    }
    
    public int getHeight(BTreeNode<E> curr)
    { 
	if(curr == null)
	{
	    return 0;
	}
	int rh = getHeight(curr.getRight());
	int lh = getHeight(curr.getLeft());
	return rh > lh ? rh + 1 : lh + 1;
    }
    
    public String getLevel(BTreeNode<E> curr, int level)
    {
	String s = "";
	if(curr == null)
	{
	    for(int i = 0; i < Math.pow(2, level); i++)
	    {
		s = s + "  ";
	    }
	    return s;
	}
	if(level == 0)
	{
	    return curr.getData() + " ";
	}
	return getLevel(curr.getLeft(), level - 1) + getLevel(curr.getRight(), level - 1);
    }
    
    public String toString()
    {
	/*String s = "";
	for(int i = getHeight() - 1; i >= 0; i--)
	{
	    s = getLevel(root, i) + "\n" + s;
	}
	return s;*/
	String s = "";
	String[] lines = toStringArray(root);
	for(int i = 0; i < lines.length; i++)
	{
	    s = s + lines[i] + "\n";
	}
	return s;
    }
    
    private String[] toStringArray(BTreeNode<E> curr)
    {
	if(curr == null)
	{
	    return new String[0];
	}
	String[] left = toStringArray(curr.getLeft());
	String[] right = toStringArray(curr.getRight());
	String node = curr.getData() + (right.length == 0 ? "" : "--");
	String spaces;
	for(spaces = (left.length == 0 ? " " : "|"); spaces.length() < node.length(); spaces += " ")
	{ }
	if(right.length == 0)
	{
	    right = new String[1];
	    right[0] = "";
	}
	String[] result = new String[right.length + left.length + (left.length == 0 ? 0 : 1)];
	int i = 0;
	result[i] = node + right[i];
	for(i = 1; i < right.length; i++)
	{
	    result[i] = spaces + right[i];
	}
	if(left.length != 0)
	{
	    result[i++] = "|";
	    for(int j = i; i < result.length; i++)
	    {
		result[i] = left[i-j];
	    }
	}
	return result;
    } 
    
    public static void main(String[] args)
    {
        BTree<Integer> t = new BTree<Integer>();

        for (int i=0; i < 20; i++) 
            t.add(i);
        System.out.println("Pre-order: ");
        t.traverse(PRE_ORDER);
        System.out.println("In-order: ");
        t.traverse(IN_ORDER);
        System.out.println("Post-order: ");
        t.traverse(POST_ORDER);
        System.out.println("Height: " + t.getHeight());

        System.out.println(t);
    }
}