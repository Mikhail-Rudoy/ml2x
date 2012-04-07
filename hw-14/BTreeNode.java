import java.io.*;
import java.util.*;

public class BTreeNode<E>
{
    private E data;
    private BTreeNode<E> left;
    private BTreeNode<E> right;

    public BTreeNode(E d)
    {
        data = d;
        left = right = null;
    }

    //accessors
    public E getData()
    {
        return data;
    }
    public BTreeNode<E> getLeft()
    {
        return left;
    }
    public BTreeNode<E> getRight()
    {
        return right;
    }

    //mutators
    public void setData(E d)
    {
        data = d;
    }
    public void setLeft(BTreeNode<E> l)
    {
        left = l;
    }
    public void setRight(BTreeNode<E> r)
    {
        right = r;
    }
}