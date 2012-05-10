import java.io.*;
import java.util.*;
import java.lang.*;

public class WordTree
{
    private char rootLetter;
    private int numWords;
    private WordTree[] children;
    
    public WordTree()
    {
	rootLetter = 0;
	numWords = 0;
	children = new WordTree[26];
    }
    
    private WordTree(char c)
    {
	if ('a' <= c && c <= 'z')
	{
	    rootLetter = c;
	}
	else if ('A' <= c && c <= 'Z')
	{
	    rootLetter = c - 'A' + 'a';
	}
	else
	{
	    throw new IllegalArgumentException("Please use an alphabetic character");
	}
	numWords = 0;
	children = new WordTree[26];
    }
    
    private WordTree(String word)
    {
	word = word.toLowerCase();
	if (word.length() == 0)
	{
	    throw new IllegalArgumentException("Please do not use empty words");
	}
	for (int i = 0; i < word.length(); i++)
	{
	    if (!('a' <= word.charAt(i) && word.charAt(i) <= 'z'))
	    {
		throw new IllegalArgumentException("Please use alphabetic characters");
	    }
	}
	else
	{
	    this(word.charAt(0));
	}
	add(word);
    }
    
    public WordTree(Iterable<String> words)
    {
	for(String word : words)
	{
	    if(word.length() == 0)
	    {
		throw new IllegalArgumentException("Please do not use empty words");
	    }
	    word = word.toLowerCase();
	    for (int i = 0; i < word.length(); i++)
	    {
		if (!('a' <= word.charAt(i) && word.charAt(i) <= 'z'))
		{
		    throw new IllegalArgumentException("Please use alphabetic characters");
		}
	    }
	}
	this();
	for(String word : words)
	{
	    add(word);
	}
    }
    
    public void add(String word)
    {
	word = word.toLowerCase();
	if (word.length() == 0)
	{
	    throw new IllegalArgumentException("Please do not use empty words");
	}
	for (int i = 0; i < word.length(); i++)
	{
	    if (!('a' <= word.charAt(i) && word.charAt(i) <= 'z'))
	    {
		throw new IllegalArgumentException("Please use alphabetic characters");
	    }
	}
	numWords++;
	if (rootLetter == 0)
	{
	    char next = word.charAt(0);
	    if(children[next - 'a'] == null)
	    {
		children[next - 'a'] = new WordTree(rest);
	    }
	    else
	    {
		children[next - 'a'].add(word);
	    }
	}
	else
	{
	    if (word.length() == 1)
	    {
		rootLetter = ("" + rootLetter).toUpperCase().charAt(0);
	    }
	    else
	    {
		char next = word.charAt(0);
		String rest = word.substring(1);
		if(children[next - 'a'] == null)
		{
		    children[next - 'a'] = new WordTree(rest);
		}
		else
		{
		    children[next - 'a'].add(rest);
		}
	    }
	}
    }
    
    public int size()
    {
	return numWords;
    }
    
    public int size(String prefix)
    {
	String word = prefix.toLowerCase();
	for (int i = 0; i < word.length(); i++)
	{
	    if (!('a' <= word.charAt(i) && word.charAt(i) <= 'z'))
	    {
		throw new IllegalArgumentException("Please use alphabetic characters");
	    }
	}
	if (word.length() == 0)
	{
	    return numWords;
	}
	if (rootLetter == 0)
	{
	    if(children[word.charAt(0) - 'a'] == null)
	    {
		return 0;
	    }
	    else
	    {
		return children[word.charAt(0) - 'a'].size(word);
	    }
	}
	else
	{
	    if(children[word.charAt(0) - 'a'] == null)
	    {
		return 0;
	    }
	    else
	    {
		return children[word.charAt(0) - 'a'].size(word.substring(1));
	    }
	}
    }
    
    public void traverse()
    {
	traverse("");
    }
    
    private void traverse(String prefix)
    {
	if(rootLetter >= 'A' && rootLetter <= 'Z')
	{
	    System.out.println(prefix + (char)(rootLetter - 'A' + 'a'));
	}
	prefix = prefix + ("" + rootLetter).toLowerCase().charAt(0);
	for(int i = 0; i < 26; i++)
	{
	    if (children[i] != null)
	    {
		children[i].traverse(prefix);
	    } 
	}
    }
    
    public String randomWord()
    {
	if(size() == 0)
	{
	    throw new IllegalStateException("Please enter a word first");
	}
	int randomOf = numWords;
	if(rootLetter <= 'Z' && rootLetter >= 'A')
	{
	    if((int)(Math.random() * randomOf) == 0)
	    {
		return "" + (char)(rootLetter - 'A' + 'a');
	    }
	    randomOf--;
	}
	for(int i = 0; i < 26; i++)
	{
	    if(children[i] == null)
	    {
		continue;
	    }
	    if((int)(Math.random() * randomOf) < children[i].size())
	    {
		return (rootLetter == 0 ? "" : ("" + rootLetter).toLowerCase()) + children[i].randomWord();
	    }
	    randomOf -= children[i].size();
	}
    }
}